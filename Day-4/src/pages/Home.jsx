import { Link } from "react-router-dom";
import CustomNavbar from "../components/CustomNavBar";
import Carousal from "../components/carasole";
import TypingAnimation from "../components/TypeAnimation";
import imgg from "../components/images/google.webp";
import imgi from "../components/images/ibm.png";
import app from "../components/images/appstore.png";
import play from "../components/images/playstore.png";


const Home = () =>{
    return(
        <div className="background_home">
            {/* <h1>Home</h1> */}
            <div className="container-home">
                <header className="nav-all">
                    <CustomNavbar/>
                </header>
                <main>
                    {/* <section className="caro-first">
                    <Carousal/>
                    </section> */}
                    <section className="hero">
                        <div className="home-head">

                        <h1 className="home_p"><TypingAnimation/></h1>
                        </div>
                    </section>
                        <div className="custom-slider-home">

                        <Carousal/>
                        </div>
                    <section className="testimonial_wrapper">
                        <div className="home_content1">
                        <h3>Big goals deserve big savings!</h3>

                        <p>Save $200 on your annual Coursera Plus subscription for a limited time. Whether you're starting a new career or advancing in your current role, find the right program for you. You can also unlock a 50% discount on Coursera for Teams and make 2024 the year of learning for your organization.</p>
                        </div>
                        <div className="course-home-but">
                            <p>Create you own path and build your self.</p>
                    <Link to={'/courses'}><button className="home_button-but" type="submit">Courses</button></Link>
                        </div>

                        {/* <Link to={'/inquiry'}><button className="home_button" type="submit">Enquiry</button></Link> */}
                    </section>
                    <section className="team_wrapper">
                        <p className="team_wrapper_p">We Collaborate with 300+ leading universities and companies like</p>
                        <img src={imgg} alt="Google" className="g-image"></img>
                        <img src={imgi} alt="IBM" className="ibm-image"></img>
                <footer className="footer-container">
                <p>&copy; 2024 BEC Nithin-vadaku & co. All rights reserved.</p>
                </footer>
                    <aside className="aside-home">
                        <img src={app} alt="appstore"></img>
                        <img src={play} alt="playstore"></img>
                    </aside>
                    </section>

                </main>
            </div>
        </div>
    );
};
export default Home;