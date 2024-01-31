
import '../assets/css/Profile.css'
import CustomNavbar from '../components/CustomNavBar';

const ProfilePage = () => {
  return (
    <div>

        <CustomNavbar/>
    <div className='Prof-total'>

    <div className="profile-container">
      <div className="profile-header">
        <img src="https://placekitten.com/200/200" alt="Profile" className="profile-picture" />
        <div className="profile-info">
          <h1>Nithin</h1>
          <p>Email: Nithin@gmail.com</p>
          <p>Mobile: 7894561230</p>
          <p>Location: City, Country</p>
        </div>
      </div>
      <div className="profile-stats">
        <div className="stat">
          <h4>Courses Purchased</h4>
          <p>10</p>
        </div>
        <div className="stat">
          <h4>Courses Completed</h4>
          <p>5</p>
        </div>
        <div className="stat">
          <h4>Inquiries</h4>
          <p>3</p>
        </div>
      </div>
    </div>
    </div>
    </div>
  );
};

export default ProfilePage;
