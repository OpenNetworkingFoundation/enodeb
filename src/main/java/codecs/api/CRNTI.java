/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package codecs.api;

import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;


public class CRNTI extends BerBitString {

	private static final long serialVersionUID = 1L;

	public CRNTI() {
	}

	public CRNTI(byte[] code) {
		super(code);
	}

	public CRNTI(byte[] value, int numBits) {
		super(value, numBits);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CRNTI) {
			return Arrays.equals(value, ((CRNTI) obj).value);
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "\"" + DatatypeConverter.printHexBinary(value) + "\"";
	}
}
