import './view.css'; 

const FilterOptions = ({ onFilterChange }) => {
  const handleFilterChange = (e) => {
    const filterValue = e.target.value;
    onFilterChange(filterValue);
  };

  return (
    <div>
      <label htmlFor="filter">Filter by:</label>
      <select id="filter" onChange={handleFilterChange}>
        <option value="all">All</option>
        <option value="beginner">Beginner</option>
        <option value="intermediate">Intermediate</option>
        <option value="advanced">Advanced</option>
      </select>
    </div>
  );
};

export default FilterOptions;
