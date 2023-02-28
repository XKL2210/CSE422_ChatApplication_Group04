package ktn.chat.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.FileType;
import ktn.chat.models.File;
import ktn.chat.services.FileServices;

class FileServicesTest {
	FileServices fileServices;
	File file01;
	File file02;
	File file03;
	File file04;
	
	@BeforeAll
	static void testOnline() throws Exception {
		System.out.println("FileServicesTest Online");
		System.out.println("FileServicesTest Inititated...");
	}

	@AfterAll
	static void testOffline() throws Exception {
		System.out.println("...FileServicesTest Offline");
	}

	@BeforeEach
	void objectInitialization() throws Exception {
		file01 = new File("001","Chippin In.mp3", FileType.Audio);
        file02 = new File("002","Archangel.mp3", FileType.Audio);
        file03 = new File("003","Never Fade Away.mp3", FileType.Audio);
        file04 = new File("004","The Rebel Path.mp3", FileType.Audio);
		fileServices = new FileServices();
	}

	@Test
	@DisplayName("Test 01: File extension test")
	void test01() throws IOException {
		fileServices.createFile(file01);
		fileServices.createFile(file02);
		fileServices.createFile(file03);
		fileServices.createFile(file04);
		assertEquals("mp3", file01.getExtension());
		assertEquals("mp3", file02.getExtension());
	}

	@Test
	@DisplayName("Test 02: Get file by id")
	void test02() throws IOException {
		assertEquals(file03, fileServices.getFileWithId("003"));
	}
	
	@Test
	@DisplayName("Test 03: Unidentified id")
	void test03() throws IOException {
		
		assertNull(fileServices.getFileWithId("005"));
	}
	
	@Test
	@DisplayName("Test 04: Get file by type")
	void test04() throws IOException {
        List<File> myPlaylist = (List<File>) fileServices.getFilesWithType(FileType.Audio);
        assertEquals(4, myPlaylist.size());
	}
	
	@Test
	@DisplayName("Test 05: Get file by name")
	void test05() throws IOException {
        List<File> myPlaylist = (List<File>) fileServices.getFilesWithName("Archangel");
        assertEquals(file02.getFilename(), myPlaylist.get(0).getFilename());
	}
	
	@Test
	@DisplayName("Test 06: Get file but empty list")
	void test06() throws IOException {
        List<File> myPlaylist = (List<File>) fileServices.getFilesWithType(FileType.Video);
        assertEquals(0, myPlaylist.size());
	}
	
	@Test
	@DisplayName("Test 07: Unindentified file name")
	void test07() throws IOException {
        List<File> myPlaylist = (List<File>) fileServices.getFilesWithName("Hello");
        assertEquals(0, myPlaylist.size());
	}
	
	@Test
	@DisplayName("Test 08: Get all")
	void test08() throws IOException {
        List<File> myPlaylist = (List<File>) fileServices.getFilesWithName(".");
        assertEquals(4, myPlaylist.size());
	}
}
