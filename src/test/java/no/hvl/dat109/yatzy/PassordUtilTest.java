package no.hvl.dat109.yatzy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.util.PassordUtil;

class PassordUtilTest {

	
	private static final String PASSORD="lkjh98765";
	private static final String FEILPASSORD="poiuytre12";
	
	
	private String salt;
	private String hash;
	
	@BeforeEach
	void setup() {
        salt = PassordUtil.genererTilfeldigSalt();
        hash = PassordUtil.hashMedSalt(PASSORD, salt);
        System.out.println(hash);
	}

	@Test
	void riktigPassordVirker() {
        assertTrue(PassordUtil.validerMedSalt(PASSORD, salt, hash));
	}

	@Test
	void feilPassordVirkerIkke() {
        assertFalse(PassordUtil.validerMedSalt(FEILPASSORD, salt, hash));
	}
	
	@Test
	void tomHashVirkerIkke() {
        assertFalse(PassordUtil.validerMedSalt(FEILPASSORD, salt, ""));
	}
	
	@Test
	void nullPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordUtil.hashMedSalt(null, salt));
	}
	
	@Test
	void nullPassordKasterUnntak2() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordUtil.validerMedSalt(null, salt, hash));
	}
	
	@Test
	void nullHashKasterUnntak() {
        assertThrows(IllegalArgumentException.class, 
        		() -> PassordUtil.validerMedSalt(PASSORD, salt, null));
	}
}
