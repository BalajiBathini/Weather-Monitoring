// src/components/WeatherSummary.jsx



const WeatherSummary = ({ summary }) => {
    return (
        <div className="weather-summary">
            <h3>{summary.city}</h3>
            <p>Date: {summary.date}</p>
            <p>Average Temperature: {summary.averageTemp} °C</p>
            <p>Max Temperature: {summary.maxTemp} °C</p>
            <p>Min Temperature: {summary.minTemp} °C</p>
            <p>Dominant Weather: {summary.dominantWeather}</p>
        </div>
    );
};

export default WeatherSummary;
