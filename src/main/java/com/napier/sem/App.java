package com.napier.sem;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        // TODO code application logic here

        DB dao = new DB();

        Scanner obj = new Scanner(System.in);

        int i = 1;

        while(i!=0){
            i = obj.nextInt();

            switch(i){

                case 1:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "ORDER BY Population DESC");
                    break;

                case 2:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "WHERE Continent = 'ASIA'\n" +
                            "ORDER BY population DESC");
                    break;

                case 3:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "WHERE Region = 'your_region_name'\n" +
                            "ORDER BY Population DESC");
                    break;

                case 4:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 5:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "WHERE Continent = 'ASIA'\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 6:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM country\n" +
                            "WHERE Region = :region_name\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 7:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 8:
                    dao.queryExe("SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.Continent = 'Asia'\n" +
                            "ORDER BY city.Population DESC;");
                    break;

                case 9:
                    dao.queryExe("SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.Region = 'Southeast Asia'\n" +
                            "ORDER BY city.Population DESC;");
                    break;

                case 10:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE CountryCode = 'USA'\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 11:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE District = 'your_district_name'\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 12:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 13:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city c\n" +
                            "INNER JOIN country co ON c.CountryCode = co.Code\n" +
                            "WHERE co.Continent = 'Europe'\n" +
                            "ORDER BY c.Population DESC\n" +
                            ";");
                    break;

                case 14:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE District = 'California'\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 15:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE CountryCode = 'USA'\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 16:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE District = 'California'\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 17:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            ")\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 18:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            "    WHERE Continent = 'your_continent_name'\n" +
                            ")\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 19:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            "    WHERE Region = 'your_region_name'\n" +
                            ")\n" +
                            "ORDER BY Population DESC;");
                    break;

                case 20:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            ")\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 21:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            "    WHERE Continent = 'your_continent_name'\n" +
                            ")\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 22:
                    dao.queryExe("SELECT Name, Population\n" +
                            "FROM city\n" +
                            "WHERE ID IN (\n" +
                            "    SELECT Capital\n" +
                            "    FROM country\n" +
                            "    WHERE Region = 'your_region_name'\n" +
                            ")\n" +
                            "ORDER BY Population DESC\n" +
                            ";");
                    break;

                case 23:
                    dao.queryExe("SELECT continent, SUM(population) AS total_population, \n" +
                            "       SUM(IF(City.Population IS NULL, 0, City.Population)) AS population_in_cities, \n" +
                            "       SUM(IF(City.Population IS NULL, population, population-City.Population)) AS population_not_in_cities\n" +
                            "FROM country\n" +
                            "LEFT JOIN (\n" +
                            "    SELECT CountryCode, SUM(Population) AS Population \n" +
                            "    FROM city\n" +
                            "    GROUP BY CountryCode\n" +
                            ") AS City ON Country.Code = City.CountryCode\n" +
                            "GROUP BY continent;");
                    break;

                case 24:
                    dao.queryExe("SELECT region, SUM(population) AS total_population, \n" +
                            "       SUM(IF(City.Population IS NULL, 0, City.Population)) AS population_in_cities, \n" +
                            "       SUM(IF(City.Population IS NULL, population, population-City.Population)) AS population_not_in_cities\n" +
                            "FROM country\n" +
                            "LEFT JOIN (\n" +
                            "    SELECT CountryCode, SUM(Population) AS Population \n" +
                            "    FROM city\n" +
                            "    GROUP BY CountryCode\n" +
                            ") AS City ON country.Code = City.CountryCode\n" +
                            "GROUP BY region;");
                    break;

                case 25:
                    dao.queryExe("SELECT name AS country, population AS total_population, \n" +
                            "       IF(City.Population IS NULL, 0, City.Population) AS population_in_cities, \n" +
                            "       IF(City.Population IS NULL, population, population-City.Population) AS population_not_in_cities\n" +
                            "FROM country\n" +
                            "LEFT JOIN (\n" +
                            "    SELECT CountryCode, SUM(Population) AS Population \n" +
                            "    FROM city\n" +
                            "    GROUP BY CountryCode\n" +
                            ") AS City ON country.Code = City.CountryCode;");
                    break;

                case 26:
                    dao.queryExe("SELECT SUM(Population) AS 'World Population' FROM country;");
                    break;

                case 27:
                    dao.queryExe("SELECT SUM(Population) AS 'Continent Population' FROM country WHERE Continent = 'continent_name';");
                    break;

                case 28:
                    dao.queryExe("SELECT SUM(Population) AS 'Region Population' FROM country WHERE Region = 'region_name';");
                    break;

                case 29:
                    dao.queryExe("SELECT Population AS 'Country Population' FROM country WHERE Name = 'country_name';");
                    break;

                case 30:
                    dao.queryExe("SELECT SUM(Population) AS 'District Population' FROM city WHERE District = 'district_name';");
                    break;

                case 31:
                    dao.queryExe("SELECT Population AS 'City Population' FROM city WHERE Name = 'city_name';");
                    break;

                case 32:
                    dao.queryExe("SELECT \n" +
                            "  c.Continent,\n" +
                            "  SUM(c.Population) AS 'Total Population',\n" +
                            "  SUM(ci.Population) AS 'Population Living in Cities',\n" +
                            "  (SUM(c.Population) - SUM(ci.Population)) AS 'Population Not Living in Cities',\n" +
                            "  CONCAT(ROUND((SUM(ci.Population) / SUM(c.Population)) * 100, 2), '%') AS '% Population Living in Cities'\n" +
                            "FROM country c\n" +
                            "LEFT JOIN city ci ON c.Code = ci.CountryCode\n" +
                            "GROUP BY c.Continent;");
                    break;

                case 33:
                    dao.queryExe("SELECT \n" +
                            "  c.Region,\n" +
                            "  SUM(c.Population) AS 'Total Population',\n" +
                            "  SUM(ci.Population) AS 'Population Living in Cities',\n" +
                            "  (SUM(c.Population) - SUM(ci.Population)) AS 'Population Not Living in Cities',\n" +
                            "  CONCAT(ROUND((SUM(ci.Population) / SUM(c.Population)) * 100, 2), '%') AS '% Population Living in Cities'\n" +
                            "FROM country c\n" +
                            "LEFT JOIN city ci ON c.Code = ci.CountryCode\n" +
                            "GROUP BY c.Region;");
                    break;

                case 34:
                    dao.queryExe("SELECT \n" +
                            "  c.Name AS 'Country',\n" +
                            "  c.Population AS 'Total Population',\n" +
                            "  SUM(ci.Population) AS 'Population Living in Cities',\n" +
                            "  (c.Population - SUM(ci.Population)) AS 'Population Not Living in Cities',\n" +
                            "  CONCAT(ROUND((SUM(ci.Population) / c.Population) * 100, 2), '%') AS '% Population Living in Cities'\n" +
                            "FROM country c\n" +
                            "LEFT JOIN city ci ON c.Code = ci.CountryCode\n" +
                            "GROUP BY c.Code;");
                    break;

                case 35:
                    dao.queryExe("SELECT c.Name, c.Population, \n" +
                            "ROUND((c.Population - SUM(ci.Population)) / c.Population * 100, 2) AS PercentageNotLivingInCities \n" +
                            "FROM country c\n" +
                            "LEFT JOIN city ci ON c.Code = ci.CountryCode \n" +
                            "WHERE c.Name = 'your_country_name'\n" +
                            "GROUP BY c.Name, c.Population");
                    break;

            }


        }

    }

}
