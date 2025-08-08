# Community Noise Reporting System (CNRRS)

A comprehensive web application built with Spring Boot for reporting and managing community noise complaints. This system allows citizens to submit noise reports with location details, descriptions, and optional image attachments, while providing administrators with tools to view and manage all submitted reports.

## Contributors 
1] [Tanishq Shivasharan](https://github.com/Tanishq747Shivasharan) Lead Backend Developer for this project and design picker
2] Aryan Jakkal 

## Table of Contents

- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Dependencies](#dependencies)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Database Setup](#database-setup)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Component Integration](#component-integration)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Community Noise Reporting System (CNRRS) is designed to facilitate community engagement in noise pollution monitoring. Citizens can easily report noise disturbances through an intuitive web interface, while administrators can track, analyze, and manage these reports effectively.

### Key Benefits:
- **Community Engagement**: Empowers citizens to actively participate in noise pollution monitoring
- **Data Collection**: Systematic collection of noise complaint data with timestamps and locations
- **Administrative Oversight**: Centralized dashboard for managing and analyzing reports
- **Responsive Design**: Mobile-friendly interface for on-the-go reporting
- **File Upload Support**: Option to attach photographic evidence with reports

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── yourpackage/
│   │           ├── Application.java              # Main Spring Boot application class
│   │           ├── controller/
│   │           │   └── NoiseReportController.java # Web controller for handling requests
│   │           ├── model/
│   │           │   └── NoiseReport.java          # Entity class for noise reports
│   │           ├── repository/
│   │           │   └── NoiseReportRepository.java # JPA repository interface
│   │           └── service/
│   │               └── NoiseReportService.java    # Business logic service
│   └── resources/
│       ├── templates/
│       │   ├── index.html                        # Home page - displays all reports
│       │   └── report.html                       # Report submission form
│       ├── static/
│       │   ├── css/                             # Custom stylesheets
│       │   ├── js/                              # JavaScript files
│       │   └── images/                          # Static images
│       └── application.properties                # Application configuration
└── pom.xml                                       # Maven dependencies and build configuration
```

## Technologies Used

- **Backend Framework**: Spring Boot 3.x
- **Template Engine**: Thymeleaf
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Frontend**: HTML5, CSS3, JavaScript (with Font Awesome icons)
- **Java Version**: 17+

## Dependencies

### Core Spring Boot Starters
```xml
<!-- Web MVC and embedded Tomcat -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Thymeleaf template engine -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Spring Data JPA with Hibernate -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### Database Driver
```xml
<!-- PostgreSQL JDBC driver -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Development Tools
```xml
<!-- Spring Boot DevTools for development -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

## Features

### User Features
- **Submit Noise Reports**: Easy-to-use form for reporting noise incidents
- **Category Selection**: Predefined categories for different types of noise (traffic, construction, etc.)
- **Location Specification**: Text-based location input with examples
- **Detailed Descriptions**: Text area for describing the noise issue
- **Image Upload**: Optional file upload for photographic evidence
- **Responsive Design**: Mobile-friendly interface

### Administrative Features
- **View All Reports**: Comprehensive list of all submitted reports
- **Report Management**: Ability to delete inappropriate or resolved reports
- **Timestamp Tracking**: Automatic recording of report submission times
- **Data Export**: Potential for CSV/Excel export of report data

### Technical Features
- **RESTful Architecture**: Clean API design following REST principles
- **Database Persistence**: Reliable data storage with PostgreSQL
- **Validation**: Form validation on both client and server sides
- **Error Handling**: Graceful error handling and user feedback
- **Security**: Basic security measures against common web vulnerabilities

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/community-noise-reporting-system.git
   cd community-noise-reporting-system
   ```

2. **Configure Maven dependencies**
   ```bash
   mvn clean install
   ```

### Database Setup

1. **Create PostgreSQL database**
   ```sql
   CREATE DATABASE cnrrsdb;
   CREATE USER postgres WITH ENCRYPTED PASSWORD 'tan3533';
   GRANT ALL PRIVILEGES ON DATABASE cnrrsdb TO postgres;
   ```

2. **Update application.properties** (if needed)
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/cnrrsdb
   spring.datasource.username=postgres
   spring.datasource.password=tan3533
   ```

### Running the Application

1. **Start PostgreSQL service**
   ```bash
   # On Ubuntu/Debian
   sudo systemctl start postgresql
   
   # On macOS with Homebrew
   brew services start postgresql
   
   # On Windows
   net start postgresql-x64-12
   ```

2. **Run the Spring Boot application**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the application**
   - Open your browser and navigate to `http://localhost:8080`
   - The home page displays all submitted reports
   - Click "Submit New Report" to file a noise complaint

## Usage

### Submitting a Noise Report
1. Navigate to the home page
2. Click the "Submit New Report" button
3. Fill in the form with:
   - Category (select from dropdown)
   - Location (e.g., "MG Road, Pune")
   - Description of the noise issue
   - Optional: Upload an image
4. Click "Submit Report"
5. You'll be redirected to the home page showing your new report

### Viewing Reports
- The home page displays all reports in a tabular format
- Each report shows: Category, Location, Date/Time, and Description
- Administrators can delete reports using the delete button

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Display home page with all reports |
| GET | `/report` | Show the report submission form |
| POST | `/submit` | Process form submission and save report |
| POST | `/delete/{id}` | Delete a specific report (admin only) |

## Configuration

### Application Properties
The `application.properties` file contains key configuration settings:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/cnrrsdb
spring.datasource.username=postgres
spring.datasource.password=tan3533

# JPA/Hibernate Configuration  
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Thymeleaf Configuration
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# Server Configuration
server.port=8080
```

### Environment-Specific Configuration
For production deployment, consider:
- Using environment variables for sensitive data
- Setting up SSL/TLS certificates
- Configuring connection pooling
- Implementing logging configurations

## Component Integration

### Using CNRRS as a Component in Larger Projects

This noise reporting system can be easily integrated into larger municipal or community management platforms:

#### 1. **Microservices Architecture**
```java
// Example integration as a microservice
@RestController
@RequestMapping("/api/noise-reports")
public class NoiseReportAPIController {
    
    @Autowired
    private NoiseReportService noiseReportService;
    
    // Expose REST endpoints for external consumption
    @GetMapping("/recent")
    public List<NoiseReport> getRecentReports() {
        return noiseReportService.getRecentReports();
    }
}
```

#### 2. **Database Integration**
- Export data to CSV/JSON for analytics platforms
- Integrate with GIS systems for location mapping
- Connect to business intelligence tools

#### 3. **Authentication Integration**
```java
// Add Spring Security for user management
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Configure authentication with existing user systems
}
```

#### 4. **Notification Systems**
```java
// Example service for notifications
@Service
public class NotificationService {
    
    @EventListener
    public void handleNewReport(NoiseReportCreatedEvent event) {
        // Send notifications to relevant authorities
        // Integration with email/SMS services
    }
}
```

### Integration Examples

#### Municipal Platform Integration
- **Citizen Portal**: Embed noise reporting as a module in citizen service portals
- **GIS Integration**: Connect with mapping systems to visualize noise complaints geographically  
- **Analytics Dashboard**: Feed data into city management dashboards
- **Mobile Apps**: Use REST APIs to power mobile applications

#### IoT Integration
- **Sensor Data**: Correlate citizen reports with noise sensor readings
- **Automated Alerts**: Trigger reports based on sensor thresholds
- **Data Validation**: Cross-reference citizen reports with sensor data

#### Third-Party Service Integration
- **Weather API**: Correlate noise complaints with weather patterns
- **Traffic Systems**: Link reports with traffic management systems
- **Social Media**: Integration with social platforms for broader community engagement

### Scalability Considerations
- **Database Sharding**: For handling large volumes of reports
- **Caching**: Implement Redis for frequently accessed data
- **Load Balancing**: Deploy multiple instances behind a load balancer
- **Message Queues**: Use RabbitMQ or Apache Kafka for asynchronous processing

## Contributing

I welcome contributions to improve the Community Noise Reporting System! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Development Guidelines
- Follow Spring Boot best practices
- Write unit tests for new features
- Update documentation for any new functionality
- Use meaningful commit messages
- Ensure code follows project formatting standards

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Built with ❤️ for community engagement and environmental awareness**

For questions or support, [please open an issue](https://github.com/Tanishq747Shivasharan/Community-Noise-Reporting-System-CNRRS-/issues) in the GitHub repository.
