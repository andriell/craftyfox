/**
 * Created by Rybalko on 20.06.2016.
 */

function csvWriter(fileName) {
    var writer = app.getBean("file-writer");
    writer.init(fileName);
    var fileWriter = {
        "writer": writer,
        "write": function (s) {
            fileWriter.writer.write(s);
        },
        "flush": function () {
            fileWriter.writer.flush();
        },
        "close": function () {
            fileWriter.writer.flush();
            fileWriter.writer.close();
        }
    };
    return fileWriter;
}
