/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */
package codecs.pdu;

import codecs.api.CRNTI;
import codecs.api.ECGI;
import codecs.api.PCIARFCN;
import codecs.api.XICICPA;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerBitString;
import org.openmuc.jasn1.ber.types.BerInteger;
import org.openmuc.jasn1.ber.types.string.BerUTF8String;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class XICICConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private ECGI ecgi = null;
	private PCIARFCN pciArfcn = null;
	private CRNTI crnti = null;
	private XICICPA pa = null;
	private BerInteger startPrbDl = null;
	private BerInteger endPrbDl = null;
	private BerBitString subframeBitmaskDl = null;
	private BerInteger p0UePusch = null;
	private BerInteger startPrbUl = null;
	private BerInteger endPrbUl = null;
	private BerBitString subframeBitmaskUl = null;

	public XICICConfig() {
	}

	public XICICConfig(byte[] code) {
		this.code = code;
	}

	public void setEcgi(ECGI ecgi) {
		this.ecgi = ecgi;
	}

	public ECGI getEcgi() {
		return ecgi;
	}

	public void setPciArfcn(PCIARFCN pciArfcn) {
		this.pciArfcn = pciArfcn;
	}

	public PCIARFCN getPciArfcn() {
		return pciArfcn;
	}

	public void setCrnti(CRNTI crnti) {
		this.crnti = crnti;
	}

	public CRNTI getCrnti() {
		return crnti;
	}

	public void setPa(XICICPA pa) {
		this.pa = pa;
	}

	public XICICPA getPa() {
		return pa;
	}

	public void setStartPrbDl(BerInteger startPrbDl) {
		this.startPrbDl = startPrbDl;
	}

	public BerInteger getStartPrbDl() {
		return startPrbDl;
	}

	public void setEndPrbDl(BerInteger endPrbDl) {
		this.endPrbDl = endPrbDl;
	}

	public BerInteger getEndPrbDl() {
		return endPrbDl;
	}

	public void setSubframeBitmaskDl(BerBitString subframeBitmaskDl) {
		this.subframeBitmaskDl = subframeBitmaskDl;
	}

	public BerBitString getSubframeBitmaskDl() {
		return subframeBitmaskDl;
	}

	public void setP0UePusch(BerInteger p0UePusch) {
		this.p0UePusch = p0UePusch;
	}

	public BerInteger getP0UePusch() {
		return p0UePusch;
	}

	public void setStartPrbUl(BerInteger startPrbUl) {
		this.startPrbUl = startPrbUl;
	}

	public BerInteger getStartPrbUl() {
		return startPrbUl;
	}

	public void setEndPrbUl(BerInteger endPrbUl) {
		this.endPrbUl = endPrbUl;
	}

	public BerInteger getEndPrbUl() {
		return endPrbUl;
	}

	public void setSubframeBitmaskUl(BerBitString subframeBitmaskUl) {
		this.subframeBitmaskUl = subframeBitmaskUl;
	}

	public BerBitString getSubframeBitmaskUl() {
		return subframeBitmaskUl;
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
		if (subframeBitmaskUl != null) {
			codeLength += subframeBitmaskUl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 10
			os.write(0x8A);
			codeLength += 1;
		}

		if (endPrbUl != null) {
			codeLength += endPrbUl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 9
			os.write(0x89);
			codeLength += 1;
		}

		if (startPrbUl != null) {
			codeLength += startPrbUl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 8
			os.write(0x88);
			codeLength += 1;
		}

		if (p0UePusch != null) {
			codeLength += p0UePusch.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 7
			os.write(0x87);
			codeLength += 1;
		}

		if (subframeBitmaskDl != null) {
			codeLength += subframeBitmaskDl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 6
			os.write(0x86);
			codeLength += 1;
		}

		if (endPrbDl != null) {
			codeLength += endPrbDl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 5
			os.write(0x85);
			codeLength += 1;
		}

		if (startPrbDl != null) {
			codeLength += startPrbDl.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			os.write(0x84);
			codeLength += 1;
		}

		if (pa != null) {
			codeLength += pa.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
		}

		codeLength += crnti.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		os.write(0x82);
		codeLength += 1;

		if (pciArfcn != null) {
			codeLength += pciArfcn.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			os.write(0xA1);
			codeLength += 1;
		}

		codeLength += ecgi.encode(os, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
		os.write(0xA0);
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
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			ecgi = new ECGI();
			subCodeLength += ecgi.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			pciArfcn = new PCIARFCN();
			subCodeLength += pciArfcn.decode(is, false);
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			crnti = new CRNTI();
			subCodeLength += crnti.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			pa = new XICICPA();
			subCodeLength += pa.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			startPrbDl = new BerInteger();
			subCodeLength += startPrbDl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			endPrbDl = new BerInteger();
			subCodeLength += endPrbDl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
			subframeBitmaskDl = new BerBitString();
			subCodeLength += subframeBitmaskDl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
			p0UePusch = new BerInteger();
			subCodeLength += p0UePusch.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
			startPrbUl = new BerInteger();
			subCodeLength += startPrbUl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9)) {
			endPrbUl = new BerInteger();
			subCodeLength += endPrbUl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 10)) {
			subframeBitmaskUl = new BerBitString();
			subCodeLength += subframeBitmaskUl.decode(is, false);
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
		if (ecgi != null) {
			sb.append("\"ecgi: \"");
			ecgi.appendAsString(sb, indentLevel + 1);
		}

		if (pciArfcn != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"pciArfcn: \"");
			pciArfcn.appendAsString(sb, indentLevel + 1);
		}

		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (crnti != null) {
			sb.append("\"crnti: \"").append(crnti);
		}

		if (pa != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"pa: \"").append(pa);
		}

		if (startPrbDl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"startPrbDl: \"").append(startPrbDl);
		}

		if (endPrbDl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"endPrbDl: \"").append(endPrbDl);
		}

		if (subframeBitmaskDl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"subframeBitmaskDl: \"").append(subframeBitmaskDl);
		}

		if (p0UePusch != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"p0UePusch: \"").append(p0UePusch);
		}

		if (startPrbUl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"startPrbUl: \"").append(startPrbUl);
		}

		if (endPrbUl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"endPrbUl: \"").append(endPrbUl);
		}

		if (subframeBitmaskUl != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("\"subframeBitmaskUl: \"").append(subframeBitmaskUl);
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

	public static XrancPdu constructPacket(RRMConfig config) {
		XrancPduBody body = new XrancPduBody();
        
		XICICConfig xicicConfig = new XICICConfig();

		xicicConfig.setCrnti(config.getCrnti().getCRNTI().get(0));
		xicicConfig.setEcgi(config.getEcgi());

		try {
            xicicConfig.setEndPrbDl(config.getEndPrbDl().getSeqOf().get(0));
        } catch (Exception ignored) {}

        try {
            xicicConfig.setEndPrbUl(config.getEndPrbUl().getSeqOf().get(0));
        } catch (Exception ignored) {}

        try {
            xicicConfig.setStartPrbDl(config.getStartPrbDl().getSeqOf().get(0));
        } catch (Exception ignored) {}

        try {
            xicicConfig.setEndPrbUl(config.getStartPrbUl().getSeqOf().get(0));
        } catch (Exception ignored) {}

        body.setXICICConfig(xicicConfig);

		BerUTF8String ver = null;
		try {
			ver = new BerUTF8String("3");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		XrancApiID apiID = new XrancApiID(23);
		XrancPduHdr hdr = new XrancPduHdr();
		hdr.setVer(ver);
		hdr.setApiId(apiID);

		XrancPdu pdu = new XrancPdu();
		pdu.setHdr(hdr);
		pdu.setBody(body);
		return pdu;
	}
}
