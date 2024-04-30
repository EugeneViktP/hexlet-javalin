package org.example.hexlet.dto.courses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import org.example.hexlet.model.Course;

@AllArgsConstructor
@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
}
