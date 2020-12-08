package com.blackhillsoftware.terse;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

import org.junit.*;

public class AppTest 
{
	static final String location = "../TerseDecompress-TestData";
		
	@Test public void TestP01() throws Exception { testBinary("FB.A.TXT",        "PACK"); }
	@Test public void TestP02() throws Exception { testBinary("FB.AAA.TXT",      "PACK"); }
	@Test public void TestP03() throws Exception { testBinary("FB.ALICE29.TXT",  "PACK"); }
	@Test public void TestP04() throws Exception { testBinary("FB.ALPHABET.TXT", "PACK"); }
	@Test public void TestP05() throws Exception { testBinary("FB.ASYOULIK.TXT", "PACK"); }
	@Test public void TestP06() throws Exception { testBinary("FB.BIBLE.TXT",    "PACK"); }
	@Test public void TestP07() throws Exception { testBinary("FB.CP.HTML",      "PACK"); }
	@Test public void TestP08() throws Exception { testBinary("FB.E.COLI",       "PACK"); }
	@Test public void TestP09() throws Exception { testBinary("FB.FIELDS.C",     "PACK"); }
	@Test public void TestP00() throws Exception { testBinary("FB.GRAMMAR.LSP",  "PACK"); }
	@Test public void TestP11() throws Exception { testBinary("FB.KENNEDY.XLS",  "PACK"); }
	@Test public void TestP12() throws Exception { testBinary("FB.LCET10.TXT",   "PACK"); }
	@Test public void TestP13() throws Exception { testBinary("FB.PI.TXT",       "PACK"); }
	@Test public void TestP14() throws Exception { testBinary("FB.PLRABN12.TXT", "PACK"); }
	@Test public void TestP15() throws Exception { testBinary("FB.PTT5",         "PACK"); }
	@Test public void TestP16() throws Exception { testBinary("FB.RANDOM.TXT",   "PACK"); }
	@Test public void TestP17() throws Exception { testBinary("FB.SUM",          "PACK"); }
	@Test public void TestP18() throws Exception { testBinary("FB.WORLD192.TXT", "PACK"); }
	@Test public void TestP19() throws Exception { testBinary("FB.XARGS",        "PACK"); }
	@Test public void TestP20() throws Exception { testBinary("VB.BIBLE.TXT",    "PACK"); }
	@Test public void TestP21() throws Exception { testBinary("VB.CP.HTML",      "PACK"); }
	@Test public void TestP22() throws Exception { testBinary("VB.ENWIK8.XML",   "PACK"); }
	@Test public void TestP23() throws Exception { testBinary("VB.FIELDS.C",     "PACK"); }
	@Test public void TestP24() throws Exception { testBinary("VB.GRAMMAR.LSP",  "PACK"); }
	@Test public void TestP25() throws Exception { testBinary("VB.LCET10.TXT",   "PACK"); }
	@Test public void TestP26() throws Exception { testBinary("VB.WORLD192.TXT", "PACK"); }
	@Test public void TestP27() throws Exception { testBinary("VB.XARGS",        "PACK"); }
	
	@Test public void TestSP01() throws Exception { testBinary("FB.A.TXT",        "SPACK"); }
	@Test public void TestSP02() throws Exception { testBinary("FB.AAA.TXT",      "SPACK"); }
	@Test public void TestSP03() throws Exception { testBinary("FB.ALICE29.TXT",  "SPACK"); }
	@Test public void TestSP04() throws Exception { testBinary("FB.ALPHABET.TXT", "SPACK"); }
	@Test public void TestSP05() throws Exception { testBinary("FB.ASYOULIK.TXT", "SPACK"); }
	@Test public void TestSP06() throws Exception { testBinary("FB.BIBLE.TXT",    "SPACK"); }
	@Test public void TestSP07() throws Exception { testBinary("FB.CP.HTML",      "SPACK"); }
	@Test public void TestSP08() throws Exception { testBinary("FB.E.COLI",       "SPACK"); }
	@Test public void TestSP09() throws Exception { testBinary("FB.FIELDS.C",     "SPACK"); }
	@Test public void TestSP00() throws Exception { testBinary("FB.GRAMMAR.LSP",  "SPACK"); }
	@Test public void TestSP11() throws Exception { testBinary("FB.KENNEDY.XLS",  "SPACK"); }
	@Test public void TestSP12() throws Exception { testBinary("FB.LCET10.TXT",   "SPACK"); }
	@Test public void TestSP13() throws Exception { testBinary("FB.PI.TXT",       "SPACK"); }
	@Test public void TestSP14() throws Exception { testBinary("FB.PLRABN12.TXT", "SPACK"); }
	@Test public void TestSP15() throws Exception { testBinary("FB.PTT5",         "SPACK"); }
	@Test public void TestSP16() throws Exception { testBinary("FB.RANDOM.TXT",   "SPACK"); }
	@Test public void TestSP17() throws Exception { testBinary("FB.SUM",          "SPACK"); }
	@Test public void TestSP18() throws Exception { testBinary("FB.WORLD192.TXT", "SPACK"); }
	@Test public void TestSP19() throws Exception { testBinary("FB.XARGS",        "SPACK"); }
	@Test public void TestSP20() throws Exception { testBinary("VB.BIBLE.TXT",    "SPACK"); }
	@Test public void TestSP21() throws Exception { testBinary("VB.CP.HTML",      "SPACK"); }
	@Test public void TestSP22() throws Exception { testBinary("VB.ENWIK8.XML",   "SPACK"); }
	@Test public void TestSP23() throws Exception { testBinary("VB.FIELDS.C",     "SPACK"); }
	@Test public void TestSP24() throws Exception { testBinary("VB.GRAMMAR.LSP",  "SPACK"); }
	@Test public void TestSP25() throws Exception { testBinary("VB.LCET10.TXT",   "SPACK"); }
	@Test public void TestSP26() throws Exception { testBinary("VB.WORLD192.TXT", "SPACK"); }
	@Test public void TestSP27() throws Exception { testBinary("VB.XARGS",        "SPACK"); }
	
	@Test public void TestTP01() throws Exception { testText("FB.A.TXT",        "PACK"); }
	@Test public void TestTP06() throws Exception { testText("FB.BIBLE.TXT",    "PACK"); }
	@Test public void TestTP07() throws Exception { testText("FB.CP.HTML",      "PACK"); }
	@Test public void TestTP09() throws Exception { testText("FB.FIELDS.C",     "PACK"); }
	@Test public void TestTP00() throws Exception { testText("FB.GRAMMAR.LSP",  "PACK"); }
	@Test public void TestTP12() throws Exception { testText("FB.LCET10.TXT",   "PACK"); }
	@Test public void TestTP18() throws Exception { testText("FB.WORLD192.TXT", "PACK"); }
	@Test public void TestTP19() throws Exception { testText("FB.XARGS",        "PACK"); }
	@Test public void TestTP20() throws Exception { testText("VB.BIBLE.TXT",    "PACK"); }
	@Test public void TestTP21() throws Exception { testText("VB.CP.HTML",      "PACK"); }
	@Test public void TestTP22() throws Exception { testText("VB.ENWIK8.XML",   "PACK"); }
	@Test public void TestTP23() throws Exception { testText("VB.FIELDS.C",     "PACK"); }
	@Test public void TestTP24() throws Exception { testText("VB.GRAMMAR.LSP",  "PACK"); }
	@Test public void TestTP25() throws Exception { testText("VB.LCET10.TXT",   "PACK"); }
	@Test public void TestTP26() throws Exception { testText("VB.WORLD192.TXT", "PACK"); }
	@Test public void TestTP27() throws Exception { testText("VB.XARGS",        "PACK"); }
	
	@Test public void TestTSP01() throws Exception { testText("FB.A.TXT",        "SPACK"); }
	@Test public void TestTSP06() throws Exception { testText("FB.BIBLE.TXT",    "SPACK"); }
	@Test public void TestTSP07() throws Exception { testText("FB.CP.HTML",      "SPACK"); }
	@Test public void TestTSP09() throws Exception { testText("FB.FIELDS.C",     "SPACK"); }
	@Test public void TestTSP00() throws Exception { testText("FB.GRAMMAR.LSP",  "SPACK"); }
	@Test public void TestTSP12() throws Exception { testText("FB.LCET10.TXT",   "SPACK"); }
	@Test public void TestTSP18() throws Exception { testText("FB.WORLD192.TXT", "SPACK"); }
	@Test public void TestTSP19() throws Exception { testText("FB.XARGS",        "SPACK"); }
	@Test public void TestTSP20() throws Exception { testText("VB.BIBLE.TXT",    "SPACK"); }
	@Test public void TestTSP21() throws Exception { testText("VB.CP.HTML",      "SPACK"); }
	@Test public void TestTSP22() throws Exception { testText("VB.ENWIK8.XML",   "SPACK"); }
	@Test public void TestTSP23() throws Exception { testText("VB.FIELDS.C",     "SPACK"); }
	@Test public void TestTSP24() throws Exception { testText("VB.GRAMMAR.LSP",  "SPACK"); }
	@Test public void TestTSP25() throws Exception { testText("VB.LCET10.TXT",   "SPACK"); }
	@Test public void TestTSP26() throws Exception { testText("VB.WORLD192.TXT", "SPACK"); }
	@Test public void TestTSP27() throws Exception { testText("VB.XARGS",        "SPACK"); }
	
	private void testBinary(String file, String packSpack) throws Exception 
	{
		String tersed = location + "/TERSED/" + file + "." + packSpack;
		String untersed = location + "/ZOSBINARY/" + file;
		
		byte[] expected = Files.readAllBytes(Paths.get(untersed));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
        try (TerseDecompresser outputWriter 
        		= TerseDecompresser.create(new FileInputStream(tersed), out))
        {
        	outputWriter.decode();
        }
		assertTrue(Arrays.equals(out.toByteArray(), expected));
	}
	
	private void testText(String file, String packSpack) throws Exception 
	{
		String tersed = location + "/TERSED/" + file + "." + packSpack;
		String untersed = location + "/ZOSTEXT/" + file;
		
		// Assumes that the record separators in the ZOSTEXT file are correct for this system, 
		// i.e. the data was checked out in text mode with git crlf conversion or otherwise
		// converted.
		byte[] expected = Files.readAllBytes(Paths.get(untersed));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
        try (TerseDecompresser outputWriter 
        		= TerseDecompresser.create(new FileInputStream(tersed), out))
        {
        	outputWriter.TextFlag = true;
        	outputWriter.decode();
        }
		assertTrue(Arrays.equals(out.toByteArray(), expected));
	}
	
}
