package asia.grails.zip

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

class SampleZipController {

    def index() { }

    def downloadSampleZip() {
        response.setContentType('APPLICATION/OCTET-STREAM')
        response.setHeader('Content-Disposition', 'Attachment;Filename="example.zip"')

        ZipOutputStream zip = new ZipOutputStream(response.outputStream);
        def file1Entry = new ZipEntry('first_file.txt');
        zip.putNextEntry(file1Entry);
        zip.write("This is the content of the first file".bytes);

        def file2Entry = new ZipEntry('second_file.txt');
        zip.putNextEntry(file2Entry);
        zip.write("This is the content of the second file".bytes);

        zip.close();
    }
}
