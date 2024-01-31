
const CourseList = ({ courses }) => {
  return (
    <div>
      <h2>View All Courses</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <strong>{course.name}</strong> - {course.summary} 
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList;
