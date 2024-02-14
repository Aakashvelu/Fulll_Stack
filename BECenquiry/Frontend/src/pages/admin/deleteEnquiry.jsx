// import { useEffect, useState } from 'react';
// import { useParams } from 'react-router-dom';

// const DeleteEnquiryPage = () => {
//   const { enquiryId } = useParams();
//   const [message, setMessage] = useState('');

//   useEffect(() => {
//     const token = localStorage.getItem('token');

//     fetch(`http://localhost:8181/api/v1/user/enquiry/${enquiryId}`, {
//       method: 'DELETE',
//       headers: {
//         Authorization: `Bearer ${token}`,
//       },
//     })
//       .then((response) => {
//         if (response.ok) {
//           setMessage('Enquiry deleted successfully.');
//         } else {
//           setMessage('Failed to delete enquiry.');
//         }
//       })
//       .catch((error) => {
//         setMessage('Failed to delete enquiry.');
//       });
//   }, [enquiryId]);

//   return (
//     <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', textAlign: 'center', color: '#333' }}>
//       <div>
//         <h1>Delete Enquiry</h1>
//         <p>{message}</p>
//       </div>
//     </div>
//   );
// };

// export default DeleteEnquiryPage;

import  { useState } from 'react';

const DeleteEnquiryPage = () => {
  const [enquiryId, setEnquiryId] = useState('');
  const [message, setMessage] = useState('');

  const handleDeleteEnquiry = () => {
    const token = localStorage.getItem('token');

    fetch(`http://localhost:8181/api/v1/user/enquiry/${enquiryId}`, {
      method: 'DELETE',
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
      .then((response) => {
        if (response.ok) {
          setMessage('Enquiry deleted successfully.');
          window.alert('Enquiry deleted successfully.');
        } else {
          setMessage('Failed to delete enquiry.');
          window.alert('Failed to delete enquiry.');
        }
      })
      .catch(() => {
        setMessage('Failed to delete enquiry.');
        window.alert('Failed to delete enquiry.');
      });
  };

  return (
    <div>
      <h1>Delete Enquiry</h1>
      <label htmlFor="enquiryId">Enquiry ID:</label>
      <input
        type="text"
        id="enquiryId"
        value={enquiryId}
        onChange={(e) => setEnquiryId(e.target.value)}
      />
      <button onClick={handleDeleteEnquiry}>Delete</button>
      <p>{message}</p>
    </div>
  );
};

export default DeleteEnquiryPage;
