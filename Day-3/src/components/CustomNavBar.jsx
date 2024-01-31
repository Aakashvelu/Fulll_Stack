import { Navbar, Nav } from 'rsuite';
import HomeIcon from '@rsuite/icons/legacy/Home';
import CogIcon from '@rsuite/icons/legacy/Cog';
import {Link, NavLink} from "react-router-dom";
const CustomNavbar = () =>{
    return(
        <Navbar className="rs-navbar" pullRight>
    <Navbar.Brand href="#">BEC</Navbar.Brand>
    <Nav>
      <Nav.Item icon={<HomeIcon />}><Link to={'/home'}>Home</Link></Nav.Item>
      <Nav.Item><Link to={'/courses'}>Courses</Link></Nav.Item>
      <Nav.Item><Link to={'/about'}>About Us</Link></Nav.Item>
      {/* <Nav.Menu title="Company">
        
        <Nav.Item>Team</Nav.Item>
        <Nav.Menu title="Contact">
          <Nav.Item><Link to={'/contact'}>Via email</Link></Nav.Item>
          <Nav.Item><Link to={'/contact'}>Via mobile</Link></Nav.Item>
        </Nav.Menu>
      </Nav.Menu> */}
    </Nav>
    <Nav pullRight>
      <Nav.Menu title="Settings" icon={<CogIcon />}>
      <Nav.Item><NavLink to={'/profile'}><button type='submit' className='but-cusNav'>Profile</button></NavLink></Nav.Item>
      <Link to="/login"><Nav.Item>Logout</Nav.Item></Link>
      </Nav.Menu>
    </Nav>
  </Navbar>
    );
};
export default CustomNavbar;