/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */
package codecs.pdu;

import codecs.api.CRNTI;
import codecs.api.ECGI;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


public class SeNBAdd implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private CRNTI crnti = null;
	private ECGI mEcgi = null;
	private ECGI sEcgi = null;
	
	public SeNBAdd() {
	}

	public SeNBAdd(byte[] code) {
		this.code = code;
	}

	public void setCrnti(CRNTI crnti) {
		this.crnti = crnti;
	}

	public CRNTI getCrnti() {
		return crnti;
	}

	public void setMEcgi(ECGI mEcgi) {
		this.mEcgi = mEcgi;
	}

	public ECGI getMEcgi() {
		return mEcgi;
	}

	public void setSEcgi(ECGI sEcgi) {
		this.sEcgi = sEcgi;
	}

	public ECGI getSEcgi() {
		return sEcgi;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += sEcgi.encode(os, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
		os.write(0xA2);
		codeLength += 1;
		
		codeLength += mEcgi.encode(os, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		os.write(0xA1);
		codeLength += 1;
		
		codeLength += crnti.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		os.write(0x80);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			crnti = new CRNTI();
			subCodeLength += crnti.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			mEcgi = new ECGI();
			subCodeLength += mEcgi.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
			sEcgi = new ECGI();
			subCodeLength += sEcgi.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (crnti != null) {
			sb.append("\"crnti\": ").append(crnti);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (mEcgi != null) {
			sb.append("\"mEcgi\": ");
			mEcgi.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (sEcgi != null) {
			sb.append("\"sEcgi\": ");
			sEcgi.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

