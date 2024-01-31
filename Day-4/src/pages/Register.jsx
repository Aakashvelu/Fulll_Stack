import { Link } from 'react-router-dom';
import { Button } from 'rsuite';
import { InputPicker } from 'rsuite';

const data = [
  'Admin',
  'User'
].map(item => ({ label: item, value: item }));

const Register = () => {
  return (
    <div className='log-body'>

    <div className="register-container">
      <h1>Register</h1>
      <form className="form" action="">
        <div className="form-field">
          <input className="input" type="text" />
          <label className="label">Username:</label>
        </div>
        <div className="form-field">
          <input className="input" type="email" />
          <label className="label">Email:</label>
        </div>
        <div className="form-field">
          <input className="input" type="password" />
          <label className="label">Password:</label>
        </div>
        <div className="form-field">
          <input className="input" type="password" />
          <label className="label">Confirm Password:</label>
        </div>
        <div className="form-field">
          <input className="input" type="text" />
          <label className="label">Mobile Number:</label>
        </div>
        <div className="form-field">
          <input className="input" type="text" />
          <label className="label">Role:</label>
          <InputPicker data={data} style={{ width: 224 }} />
        </div>
        <div className="form-field-but">
        <button type="submit" className="form-button"><Link to={'/login'}>Register</Link></button>
        </div>
        {/* <div>
          <button type='submit'>Login</button>
        </div> */}
      </form>
    </div>
        </div>
  );
};

export default Register;
