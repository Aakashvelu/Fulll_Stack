const EmailInput = ({ label, value, onChange }) => {
    return (
      <div>
        <label>{label}</label>
        <input type="email" value={value} onChange={(e) => onChange(e.target.value)} />
      </div>
    );
  };
  
  export default EmailInput;