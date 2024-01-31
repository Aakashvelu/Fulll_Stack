
import React, { useState } from 'react';
import CustomNavbar from '../components/CustomNavBar';
// import './InquiryForm.css'; // Import the CSS file

const InquiryForm = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    subject: '',
    message: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Add logic to handle form submission, e.g., send an email or make an API call
    console.log('Form submitted:', formData);
  };

  return (
    <div>
      <header className="nav-all">
        <CustomNavbar/>
      </header>
    <form className="inquiry-form" onSubmit={handleSubmit}>
      <label className='in-label' htmlFor="name">Name:</label>
      <input
        type="text"
        id="name"
        name="name"
        className='subject-inquiry'
        value={formData.name}
        onChange={handleChange}
        required
        />

      <label className='in-label' htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        name="email"
        className='subject-inquiry'
        value={formData.email}
        onChange={handleChange}
        required
        />

      <label className='in-label' htmlFor="subject">Subject:</label>
      <input
        type="text"
        id="subject"
        name="subject"
        className='subject-inquiry'
        value={formData.subject}
        onChange={handleChange}
        required
        />

      <label className='in-label' htmlFor="message">Message:</label>
      <textarea
        id="message"
        name="message"
        className='subject-inquiry'
        value={formData.message}
        onChange={handleChange}
        required
        ></textarea>

      <button type="submit" className='Button-inquiry'>Submit Inquiry</button>
    </form>
        </div>
  );
};

export default InquiryForm;
