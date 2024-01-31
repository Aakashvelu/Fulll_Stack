import '../admin/esit.css';
import  { useState } from 'react';
import CustomSideNav from '../../components/CustomSideNav';

const EditCourse = () => {
  const [courseId, setCourseId] = useState('');
  const [courseName, setCourseName] = useState('');
  const [courseSummary, setCourseSummary] = useState('');
  const [courseImage, setCourseImage] = useState(null);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    if (name === 'courseId') {
      setCourseId(value);
    } else if (name === 'courseName') {
      setCourseName(value);
    } else if (name === 'courseSummary') {
      setCourseSummary(value);
    }
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    setCourseImage(file);
  };

  const handleEdit = () => {
    // Perform the course editing logic here
    // Example: axios.put(`http://your-backend-api-url/api/courses/${courseId}`, formData)
    //   .then(response => console.log(response))
    //   .catch(error => console.error(error));

    // After successful edit, you may want to reset the form
    setCourseId('');
    setCourseName('');
    setCourseSummary('');
    setCourseImage(null);
  };

  return (
    <div>
        <CustomSideNav/>
        <div className='edit-body'>

    <div className='edit-container'>
      <h2 className='edit-h2'>Edit Course</h2>
      <div>
        <label className='edit-label' htmlFor="courseId">Course ID:</label>
        <input
        className='edit-input'
        type="text"
        id="courseId"
          name="courseId"
          value={courseId}
          onChange={handleInputChange}
          placeholder="Enter Course ID"
          />
      </div>
      <div>
        <label className='edit-label' htmlFor="courseName">Course Name:</label>
        <input
        className='edit-input'
        type="text"
        id="courseName"
        name="courseName"
        value={courseName}
        onChange={handleInputChange}
        placeholder="Enter Course Name"
        />
      </div>
      <div>
        <label className='edit-label' htmlFor="courseSummary">Course Summary:</label>
        <textarea
        className='edit-testarea'
          id="courseSummary"
          name="courseSummary"
          value={courseSummary}
          onChange={handleInputChange}
          placeholder="Enter Course Summary"
          />
      </div>
      <div>
        <label className='edit-label' htmlFor="courseImage">Course Image:</label>
        <input
        className='edit-img'
        type="file"
        id="courseImage"
        accept="image/*"
        onChange={handleImageChange}
        />
      </div>
      <button  className='edit-but' onClick={handleEdit}>Edit Course</button>
    </div>
          </div>
        </div>
  );
};

export default EditCourse;
