package repository;

import ultity.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface Repository <T> {
    default List<T> getAll1(
            String filePath,
            Function<String[], T> mapper
    ) {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(filePath);
        List<T> result = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            result.add(mapper.apply(arr));
        }

        return result;
    }
}
