function FileWriter(fileName) {
    var writer = app.getBean("file-writer");
    writer.init(fileName);
    var fileWriter = {
        "writer": writer,
        "write": function (s) {
            fileWriter.writer.write("" + s);
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
        "prefix": "",
        "writeLine": function (list) {
            var s = "";
            var prefix = "";
            if (Array.isArray(list)) {
                for (var i = 0; i < list.length; i++) {
                    s += prefix + list[i].replace(/[\t\n]/gi, " ").replace(/\r/gi, "").trim();
                    prefix = "\t";
                }
                s += "\r\n";
                fileWriter.writer.write(s);
            } else if (typeof(list) == "object") {
                for (var i in list) {
                    s += prefix + list[i].replace(/[\t\n]/gi, " ").replace(/\r/gi, "").trim();
                    prefix = "\t";
                }
                s += "\r\n";
                fileWriter.writer.write(s);
            }
        },
        "write": function (s) {
            s = "" + s;
            s = s.replace(/[\t\n]/gi, " ").replace(/\r/gi, "").trim();
            fileWriter.writer.write(fileWriter.prefix);
            fileWriter.writer.write(s);
            fileWriter.prefix = "\t";
        },
        "newLine": function () {
            fileWriter.writer.newLine();
            fileWriter.prefix = "";
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
