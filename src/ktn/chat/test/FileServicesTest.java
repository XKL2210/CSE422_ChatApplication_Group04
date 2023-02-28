package ktn.chat.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

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
	
	@BeforeAll
	static void testOnline() throws Exception {
		System.out.println("UserServicesTest Online");
		System.out.println("UserServicesTest Inititated...");
	}

	@AfterAll
	static void testOffline() throws Exception {
		System.out.println("...UserServicesTest Offline");
	}

	@BeforeEach
	void objectInitialization() throws Exception {
		file01 = new File("001","Chippin In.mp3", FileType.Audio);
        file02 = new File("002","Archangel.mp3", FileType.Audio);
		fileServices = new FileServices();
	}

	@Test
	@DisplayName("Test 01: File extension test")
	void test01() throws IOException {
		assertEquals("mp3", file01.getExtension());
		assertEquals("mp3", file02.getExtension());
	}

	@Test
	@DisplayName("Test 02: File creation")
	void test02() throws IOException {
		File file03 = new File("003","Never Fade Away.mp3", FileType.Audio);
		fileServices.createFile(file03);
		assertEquals(file03, fileServices.getFileWithId("003"));
	}
}
