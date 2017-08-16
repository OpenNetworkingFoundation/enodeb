/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package codecs.pdu;

import codecs.api.*;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.string.BerUTF8String;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RXSigMeasConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	public static class MeasCells implements Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		private List<PCIARFCN> seqOf = null;

		public MeasCells() {
			seqOf = new ArrayList<PCIARFCN>();
		}

		public MeasCells(byte[] code) {
			this.code = code;
		}

		public List<PCIARFCN> getPCIARFCN() {
			if (seqOf == null) {
				seqOf = new ArrayList<PCIARFCN>();
			}
			return seqOf;
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
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(os, true);
			}

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
			if (withTag) {
				codeLength += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);
			int totalLength = length.val;

			while (subCodeLength < totalLength) {
				PCIARFCN element = new PCIARFCN();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
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

			sb.append("[\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (seqOf == null) {
//				sb.append("null");
			}
			else {
				Iterator<PCIARFCN> it = seqOf.iterator();
				if (it.hasNext()) {
					it.next().appendAsString(sb, indentLevel + 1);
					while (it.hasNext()) {
						sb.append(",\n");
						for (int i = 0; i < indentLevel + 1; i++) {
							sb.append("\t");
						}
						it.next().appendAsString(sb, indentLevel + 1);
					}
				}
			}

			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("]");
		}

        public void setPCIARFCN(PCIARFCN pciarfcn) {
			seqOf.add(pciarfcn);
        }
    }

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private ECGI ecgi = null;
	private CRNTI crnti = null;
	private RXSigRepQty reportQty = null;
	private MeasCells measCells = null;
	private RXSigMeasRepInterval reportInterval = null;
	
	public RXSigMeasConfig() {
	}

	public RXSigMeasConfig(byte[] code) {
		this.code = code;
	}

	public void setEcgi(ECGI ecgi) {
		this.ecgi = ecgi;
	}

	public ECGI getEcgi() {
		return ecgi;
	}

	public void setCrnti(CRNTI crnti) {
		this.crnti = crnti;
	}

	public CRNTI getCrnti() {
		return crnti;
	}

	public void setReportQty(RXSigRepQty reportQty) {
		this.reportQty = reportQty;
	}

	public RXSigRepQty getReportQty() {
		return reportQty;
	}

	public void setMeasCells(MeasCells measCells) {
		this.measCells = measCells;
	}

	public MeasCells getMeasCells() {
		return measCells;
	}

	public void setReportInterval(RXSigMeasRepInterval reportInterval) {
		this.reportInterval = reportInterval;
	}

	public RXSigMeasRepInterval getReportInterval() {
		return reportInterval;
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
		codeLength += reportInterval.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 4
		os.write(0x84);
		codeLength += 1;
		
		codeLength += measCells.encode(os, false);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
		os.write(0xA3);
		codeLength += 1;
		
		codeLength += reportQty.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		os.write(0x82);
		codeLength += 1;
		
		codeLength += crnti.encode(os, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		os.write(0x81);
		codeLength += 1;
		
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
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			crnti = new CRNTI();
			subCodeLength += crnti.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			reportQty = new RXSigRepQty();
			subCodeLength += reportQty.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			measCells = new MeasCells();
			subCodeLength += measCells.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			reportInterval = new RXSigMeasRepInterval();
			subCodeLength += reportInterval.decode(is, false);
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
			sb.append("\"ecgi\": ");
			ecgi.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append(",\n");
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
		if (reportQty != null) {
			sb.append("\"reportQty\": ").append(reportQty);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (measCells != null) {
			sb.append("\"measCells\": ");
			measCells.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (reportInterval != null) {
			sb.append("\"reportInterval\": ").append(reportInterval);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

	public static XrancPdu constructPacket(ECGI ecgi, CRNTI crnti, RXSigMeasConfig.MeasCells measCells, int interval) {
		RXSigRepQty rxSigRepQty = new RXSigRepQty(2);
		RXSigMeasRepInterval repInterval = new RXSigMeasRepInterval(interval);

		RXSigMeasConfig sigMeasConfig = new RXSigMeasConfig();
		sigMeasConfig.setCrnti(crnti);
		sigMeasConfig.setEcgi(ecgi);
		sigMeasConfig.setReportQty(rxSigRepQty);
		sigMeasConfig.setMeasCells(measCells);
		sigMeasConfig.setReportInterval(repInterval);

		XrancPduBody body = new XrancPduBody();
		body.setRXSigMeasConfig(sigMeasConfig);

		BerUTF8String ver = null;
		try {
			ver = new BerUTF8String("3");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		XrancApiID apiID = new XrancApiID(15);
		XrancPduHdr hdr = new XrancPduHdr();
		hdr.setVer(ver);
		hdr.setApiId(apiID);

		XrancPdu pdu = new XrancPdu();
		pdu.setHdr(hdr);
		pdu.setBody(body);

		return pdu;
	}

}

