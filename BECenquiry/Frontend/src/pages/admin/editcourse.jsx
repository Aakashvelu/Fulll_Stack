import '../admin/esit.css';
import { useState } from 'react';
import axios from 'axios';
import CustomSideNav from '../../components/CustomSideNav';

const EditCourse = () => {
  const [courseId, setCourseId] = useState('');
  const [img, setImg] = useState('');
  const [courseName, setCourseName] = useState('');
  const [description, setDescription] = useState('');
  const [duration, setDuration] = useState('');
  const [cost, setCost] = useState('');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    if (name === 'courseId') {
      setCourseId(value);
    } else if (name === 'img') {
      setImg(value);
    } else if (name === 'courseName') {
      setCourseName(value);
    } else if (name === 'description') {
      setDescription(value);
    } else if (name === 'duration') {
      setDuration(value);
    } else if (name === 'cost') {
      setCost(value);
    }
  };

  const handleEdit = async () => {
    try {
      const token = localStorage.getItem('token');
      const formData = {
        img,
        courseName,
        description,
        duration,
        cost
      };

      const response = await axios.put(`http://localhost:8181/api/v1/user/api/v1/course/${courseId}`, formData, {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      });

      if (response.status === 200) {
        console.log('Course edited successfully');
        // Reset the form after successful edit
        setCourseId('');
        setImg('');
        setCourseName('');
        setDescription('');
        setDuration('');
        setCost('');
        // Display a success message
        alert('Course edited successfully');
      } else {
        console.error('Failed to edit course');
      }
    } catch (error) {
      console.error('Error editing course:', error);
    }
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
            <label className='edit-label' htmlFor="img">Course Image URL:</label>
            <input
              className='edit-input'
              type="text"
              id="img"
              name="img"
              value={img}
              onChange={handleInputChange}
              placeholder="Enter Course Image URL"
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
            <label className='edit-label' htmlFor="description">Course Description:</label>
            <textarea
              className='edit-textarea'
              id="description"
              name="description"
              value={description}
              onChange={handleInputChange}
              placeholder="Enter Course Description"
            />
          </div>
          <div>
            <label className='edit-label' htmlFor="duration">Course Duration:</label>
            <input
              className='edit-input'
              type="text"
              id="duration"
              name="duration"
              value={duration}
              onChange={handleInputChange}
              placeholder="Enter Course Duration"
            />
          </div>
          <div>
            <label className='edit-label' htmlFor="cost">Course Cost:</label>
            <input
              className='edit-input'
              type="text"
              id="cost"
              name="cost"
              value={cost}
              onChange={handleInputChange}
              placeholder="Enter Course Cost"
            />
          </div>
          <button className='edit-but' onClick={handleEdit}>Edit Course</button>
        </div>
      </div>
    </div>
  );
};

export default EditCourse;
