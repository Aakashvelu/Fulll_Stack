
import { NavLink } from 'react-router-dom';
import CustomNavbar from '../components/CustomNavBar';
import '../assets/css/Courses.css'

const coursesData = [
  {
    id: 1,
    title: 'Digital Marketing',
    description: 'Explore comprehensive digital marketing courses covering SEO, social media, content creation, and more. Learn strategies to boost online visibility, engage audiences, and drive conversions. Gain hands-on experience with industry tools and analytics.',
    img: 'https://imgs.search.brave.com/RemhqXgix2NK9TVJynlczRFf5ud0z4ZIOd6yNey-gl0/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMTE3/MTkwMjExNi9waG90/by9kaWdpdGFsLW1h/cmtldGluZy1jb25j/ZXB0LmpwZz9zPTYx/Mng2MTImdz0wJms9/MjAmYz0zbGRzXzc5/YnItT3E0Wmk3QmZz/LXdBeFRudmV6OXBk/NnNtZXhyS0FIRnJN/PQ', // Add the URL of the course image
  },
  {
    id: 2,
    title: 'Data Science',
    description: 'Embark on a transformative journey in Data Science, mastering key concepts in statistical analysis, machine learning, and data visualization. Acquire skills in Python, R, and advanced analytics tools. Solve real-world problems, harness the power of data, and unlock opportunities across industries with this comprehensive Data Science course.',
    img: 'https://imgs.search.brave.com/hrofk85qMl9mMyevNCrxRjRDARieiN0c0u6gZvEztDw/rs:fit:500:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzA0LzI5Lzk5Lzg4/LzM2MF9GXzQyOTk5/ODgzN19jNXJtcU1z/NDFFSm5wWHFjRk1R/TWpjTEE0MmNEbmFK/Ri5qcGc',
  },
  {
    id: 3,
    title: 'Machine Learning',
    description: 'Dive into the world of Machine Learning with our dynamic course. Learn foundational algorithms, explore data preprocessing, and delve into model evaluation techniques. Acquire proficiency in Python and popular ML libraries. Gain hands-on experience in solving practical problems, making impactful predictions, and unlocking the potential of intelligent systems.',
    img: 'https://imgs.search.brave.com/98jY9OOO8jy5WTsNYp90bXA789gfU0L3iV123PZ5Sic/rs:fit:500:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzAyLzU4Lzg3LzEw/LzM2MF9GXzI1ODg3/MTAwOV9mNW5ldDZ0/MTc4bU1GMW5la2Rn/MkFTMnZ1T1VocERq/TC5qcGc',
  },
  // Add more courses as needed
];

const ViewAllCourses = () => {
  const handleInquiry = (courseTitle) => {
    // Add logic to handle the inquiry, e.g., open a modal, send an email, etc.
    console.log(`Inquiry for ${courseTitle}`);
  };

  return (
    <div>
      <header><CustomNavbar/></header>

      <div className="Course-home">
        {/* <h1>All Courses</h1> */}
        <div className="courses-list">
          {coursesData.map((course) => (
            <div key={course.id} className="course-card" >
              <img src={course.img} alt={course.title} className="course-image" style={{ width: '300px', height: '200px' }}/>
              <h4>{course.title}</h4>
              <p className='course-card-p'>{course.description}</p>
              <NavLink to={'/inquiry'}><button className='but-course-enqiry' onClick={() => handleInquiry(course.title) }>enquire</button></NavLink>
              <NavLink to={'/payment'}><button className='but-course-enroll'>Enroll Now</button></NavLink>
              
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ViewAllCourses;
