/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package codecs.api;

import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


public class ERABParamsItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private ERABID id = null;
	private ERABDirection direction = null;
	private ERABType type = null;
	private QCI qci = null;
	private BerInteger arp = null;
	private BitRate gbrDl = null;
	private BitRate gbrUl = null;
	private BitRate mbrDl = null;
	private BitRate mbrUl = null;
	
	public ERABParamsItem() {
	}

	public ERABParamsItem(byte[] code) {
		this.code = code;
	}

	public void setId(ERABID id) {
		this.id = id;
	}

	public ERABID getId() {
		return id;
	}

	public void setDirection(ERABDirection direction) {
		this.direction = direction;
	}

	public ERABDirection getDirection() {
		return direction;
	}

	public void setType(ERABType type) {
		this.type = type;
	}

	public ERABType getType() {
		return type;
	}

	public void setQci(QCI qci) {
		this.qci = qci;
	}

	public QCI getQci() {
		return qci;
	}

	public void setArp(BerInteger arp) {
		this.arp = arp;
	}

	public BerInteger getArp() {
		return arp;
	}

	public void setGbrDl(BitRate gbrDl) {
		this.gbrDl = gbrDl;
	}

	public BitRate getGbrDl() {
		return gbrDl;
	}

	public void setGbrUl(BitRate gbrUl) {
		this.gbrUl = gbrUl;
	}

	public BitRate getGbrUl() {
		return gbrUl;
	}

	public void setMbrDl(BitRate mbrDl) {
		this.mbrDl = mbrDl;
	}

	public BitRate getMbrDl() {
		return mbrDl;
	}

	public void setMbrUl(BitRate mbrUl) {
		this.mbrUl = mbrUl;
	}

	public BitRate getMbrUl() {
		return mbrUl;
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
		codeLength += mbrUl.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 8
		os.write(0x88);
		codeLength += 1;
		
		codeLength += mbrDl.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 7
		os.write(0x87);
		codeLength += 1;
		
		codeLength += gbrUl.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 6
		os.write(0x86);
		codeLength += 1;
		
		codeLength += gbrDl.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 5
		os.write(0x85);
		codeLength += 1;
		
		codeLength += arp.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 4
		os.write(0x84);
		codeLength += 1;
		
		codeLength += qci.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 3
		os.write(0x83);
		codeLength += 1;
		
		codeLength += type.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		os.write(0x82);
		codeLength += 1;
		
		codeLength += direction.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		os.write(0x81);
		codeLength += 1;
		
		codeLength += id.encode(os, false);
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
			id = new ERABID();
			subCodeLength += id.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			direction = new ERABDirection();
			subCodeLength += direction.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			type = new ERABType();
			subCodeLength += type.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			qci = new QCI();
			subCodeLength += qci.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			arp = new BerInteger();
			subCodeLength += arp.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			gbrDl = new BitRate();
			subCodeLength += gbrDl.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
			gbrUl = new BitRate();
			subCodeLength += gbrUl.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
			mbrDl = new BitRate();
			subCodeLength += mbrDl.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
			mbrUl = new BitRate();
			subCodeLength += mbrUl.decode(is, false);
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
		if (id != null) {
			sb.append("\"id\": ").append(id);
		}
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (direction != null) {
			sb.append("\"direction\": ").append(direction);
		}
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (type != null) {
			sb.append("\"type\": ").append(type);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (qci != null) {
			sb.append("\"qci\": ").append(qci);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (arp != null) {
			sb.append("\"arp\": ").append(arp);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (gbrDl != null) {
			sb.append("\"gbrDl\": ").append(gbrDl);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (gbrUl != null) {
			sb.append("\"gbrUl\": ").append(gbrUl);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (mbrDl != null) {
			sb.append("\"mbrDl\": ").append(mbrDl);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (mbrUl != null) {
			sb.append("\"mbrUl\": ").append(mbrUl);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

