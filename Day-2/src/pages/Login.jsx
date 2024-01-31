import { Link } from "react-router-dom";
// import Button from "../components/Button";
const Login = () =>{
    return(
        <div className="log-body">
      <video className="video-background" autoPlay loop muted>
        <source src="/background.mp4" type="video/mp4" />
        Your browser does not support the video tag.
      </video>
            

        <div className="register-container-login">
            <h2>Login</h2>
            <form action="">
            <div className="form-field">
                <input className="input" type="email"/>
                <label className="label" htmlFor="">Your Email</label>
            </div>
                <div className="form-field">
                    <input className="input" type="password"/>
                    <label className="label" htmlFor="">Your Password</label>
                </div>
            <div className="form-field">
                <button type="submit" className="form-button-log"><Link to={'/home'}>Login</Link></button>
            {/* <span className="register-button-container"><Link to={'/home'}></Link></span> */}
            </div>
            <div className="form-field">
                <span>Forget Password?</span>
            </div>
            {/* <button type="submit">Login</button> */}
            <div className="form-field">
                <span><Link to="/register">Sign up?</Link></span>
            </div>
            </form>
        </div>
        </div>

    );
};
export default Login;