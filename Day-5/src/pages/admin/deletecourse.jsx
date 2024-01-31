// src/DeleteCourse.jsx
import React, { useState } from 'react';
import CustomSideNav from '../../components/CustomSideNav';
import '../admin/delete.css'

const DeleteCourse = () => {
  const [courseId, setCourseId] = useState('');

  const handleInputChange = (e) => {
    setCourseId(e.target.value);
  };

  const handleDelete = () => {
    // Perform the course deletion logic here
    // Example: axios.delete(`http://your-backend-api-url/api/courses/${courseId}`)
    //   .then(response => console.log(response))
    //   .catch(error => console.error(error));

    // After successful deletion, you may want to reset the form
    setCourseId('');
  };

  return (
    <div>
        <CustomSideNav/>
        <div className='delete-body'>

    <div className='delete-container'>
      <h2 className='delet-h2'>Delete Course</h2>
      <div>
        <label className='delete-label' htmlFor="courseId">Course ID:</label>
        <input
          type="text"
          className='delete-input'
          id="courseId"
          value={courseId}
          onChange={handleInputChange}
          placeholder="Enter Course ID"
          />
      </div>
      <button className='delete-but' onClick={handleDelete}>Delete Course</button>
    </div>
    </div>
          </div>
  );
};

export default DeleteCourse;
