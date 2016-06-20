/**
 * Created by Rybalko on 20.06.2016.
 */

function FileWriter(fileName) {
    var writer = app.getBean("file-writer");
    writer.init(fileName);
    var fileWriter = {
        "writer": writer,
        "write": function (s) {
            fileWriter.writer.write(s);
        },
        "newLine": function () {
            fileWriter.writer.newLine();
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


function CsvWriter(fileName) {
    var writer = app.getBean("file-writer");
    writer.init(fileName);
    var fileWriter = {
        "writer": writer,
        "write": function (list) {
            var prefix = "";
            if (Array.isArray(list)) {
                for(var i = 0; i < list.length; i++) {
                    fileWriter.writer.write(prefix);
                    fileWriter.writer.write(list[i].replace("\t", " "));
                    prefix = "\t";
                }
                fileWriter.writer.newLine();
            } else if (typeof(list) == "object") {
                for(var i in list) {
                    fileWriter.writer.write(prefix);
                    fileWriter.writer.write(list[i].replace("\t", " "));
                    prefix = "\t";
                }
                fileWriter.writer.newLine();
            }
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