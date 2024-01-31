import '../assets/css/team.css';
import CustomSideNav from '../components/CustomSideNav';

const Manageteam = () => {
  const teamData = [
    { id: 1, name: 'John Doe', email: 'john.doe@example.com', mobile: '1234567890', age: 30, join_year: 2020 },
    { id: 2, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 3, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 4, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 5, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 6, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 7, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 8, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 9, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 10, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 11, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 12, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 13, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 14, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    { id: 15, name: 'Jane Smith', email: 'jane.smith@example.com', mobile: '9876543210', age: 25, join_year: 2021 },
    
  ];

  return (
    <div>
        <CustomSideNav/>
    <div className='main-team'>
      {/* <h1 style={{textAlign:"center"}}>Team Manager</h1> */}
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Age</th>
            <th>Join Year</th>
          </tr>
        </thead>
        <tbody>
          {teamData.map(user => (
              <tr key={user.id}>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.mobile}</td>
              <td>{user.age}</td>
              <td>{user.join_year}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
          </div>
  );
};

export default Manageteam;
