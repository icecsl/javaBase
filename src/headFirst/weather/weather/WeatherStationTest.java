package headFirst.weather.weather;

import headFirst.weather.weather.impl.CurrentConditionsDisplay;
import headFirst.weather.weather.impl.ForecastDisplay;
import headFirst.weather.weather.impl.WeatherData;

/**
 * @Author: huangbingjing
 * @DATE: 2020-11-24
 */
public class WeatherStationTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }
}
