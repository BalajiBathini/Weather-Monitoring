// src/components/WeatherSummary.jsx


const WeatherSummary = ({ summary, unit }) => {
    const convertTemp = (temp, unit) => {
        return unit === 'C' ? temp : (temp * 9) / 5 + 32; // Convert to Fahrenheit if necessary
    };
    

    return (
        <div className="weather-summary lg-4">
            <h3>{summary.city}</h3>
            <p>Date: {summary.date}</p>
            <p>Average Temperature: {convertTemp(summary.averageTemp, unit)} °{unit}</p>
            <p>Max Temperature: {convertTemp(summary.maxTemp, unit)} °{unit}</p>
            <p>Min Temperature: {convertTemp(summary.minTemp, unit)} °{unit}</p>
            <p>Dominant Weather: {summary.dominantWeather}</p>
        </div>
    );
};

export default WeatherSummary;

