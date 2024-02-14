

// import { useState } from 'react';
// import CustomSideNav from '../../components/CustomSideNav';
// import axios from 'axios';
// import '../admin/delete.css';

// const DeleteCourse = () => {
//   const [courseId, setCourseId] = useState('');
//   const [showSuccessMessage, setShowSuccessMessage] = useState(false);

//   const handleInputChange = (e) => {
//     setCourseId(e.target.value);
//   };

//   const handleDelete = async () => {
//     try {
//       // Send DELETE request to the API to delete the course
//       const response = await axios.delete(`http://localhost:8181/api/v1/user/api/v1/course/${courseId}`);

//       // Check if the course is successfully deleted (status code 200)
//       if (response.status === 200) {
//         // Display success message
//         setShowSuccessMessage(true);
//         // Reset the courseId input field
//         setCourseId('');
//       } else {
//         console.error('Failed to delete course');
//       }
//     } catch (error) {
//       console.error('Error deleting course:', error);
//     }
//   };

//   return (
//     <div>
//       <CustomSideNav/>
//       <div className='delete-body'>
//         <div className='delete-container'>
//           <h2 className='delet-h2'>Delete Course</h2>
//           <div>
//             <label className='delete-label' htmlFor="courseId">Course ID:</label>
//             <input
//               type="text"
//               className='delete-input'
//               id="courseId"
//               value={courseId}
//               onChange={handleInputChange}
//               placeholder="Enter Course ID"
//             />
//           </div>
//           <button className='delete-but' onClick={handleDelete}>Delete Course</button>
//         </div>
//       </div>
//       {showSuccessMessage && (
//         <div className="success-message">
//           <p>Course deleted successfully!</p>
//         </div>
//       )}
//     </div>
//   );
// };

// export default DeleteCourse;
import { useState } from 'react';
import axios from 'axios';
import CustomSideNav from '../../components/CustomSideNav';
import '../admin/delete.css';

const DeleteCourse = () => {
  const [courseId, setCourseId] = useState('');

  const handleInputChange = (e) => {
    setCourseId(e.target.value);
  };

  const handleDelete = async () => {
    const token = localStorage.getItem('token');

    try {
      const response = await axios.delete(`http://localhost:8181/api/v1/user/api/v1/course/${courseId}`, {
        headers: {
          'Authorization': `Bearer ${token}`
        }
      });

      if (response.status === 200) {
        console.log('Course deleted successfully');
        // Reset the form after successful deletion
        setCourseId('');
        // Display a success message or handle it as needed
        alert('Course deleted successfully');
      } else {
        console.error('Failed to delete course');
      }
    } catch (error) {
      console.error('Error deleting course:', error);
    }
  };

  return (
    <div>
      <CustomSideNav />
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
