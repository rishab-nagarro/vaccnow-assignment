# VaccNow REST API

VaccNow is a RESTful API that provides endpoints for managing vaccination services.
It allows users to perform various operations related to vaccination centers, available vaccines, appointments, and vaccination records.

Endpoints
* Get All Branches
Endpoint: /branches
Method: GET
Produces: application/json
Description: Retrieves a list of all vaccination branches.
Response: Returns a JSON array of BranchResponse objects containing information about each branch.

* Get Available Vaccines by Branch
Endpoint: /branches/{branchId}/vaccines
Method: GET
Produces: application/json
Description: Retrieves a list of available vaccines at the specified branch.
Parameters: branchId - ID of the branch
Response: Returns a JSON array of AvailableVaccineResponse objects containing information about each available vaccine.

* Get Availability by Branch
Endpoint: /branches/{branchId}/availability
Method: GET
Produces: application/json
Description: Retrieves availability information for the specified branch.
Parameters: branchId - ID of the branch
Response: Returns a JSON array of AvailabilityResponse objects containing availability information.

* Get Available Time Slots
Endpoint: /branches/{branchId}/availability/{date}/timeslots
Method: GET
Produces: application/json
Description: Retrieves available time slots for appointments at the specified branch and date.
Parameters:
branchId - ID of the branch
date - Date for which time slots are requested(YYYY-MM-DD)
Response: Returns a JSON object of TimeSlots containing available time slots.

* Schedule Vaccine Appointment
Endpoint: /branches/{branchId}/vaccinate
Method: POST
Consumes: application/json
Produces: application/json
Description: Schedules a vaccine appointment at the specified branch.
Parameters:
branchId - ID of the branch
Request Body: ScheduleVaccineRequest object containing appointment details
Sample Request Body: 
  {
  "vaccineId": 1,
  "customerName": "customer name",
  "customerEmail":"customer email",
  "scheduledDateTime":"2024-03-04T09:00:00",
  "paymentMethod": "Cash"
  }
Response: Returns a JSON object of ScheduleVaccineResponse containing details of the scheduled appointment.

* Get Applied Vaccinations per Branch
Endpoint: /branches/{branchId}/vaccinations
Method: GET
Produces: application/json
Description: Retrieves a list of applied vaccinations at the specified branch.
Parameters: branchId - ID of the branch
Response: Returns a JSON array of VaccinationResponse objects containing information about each applied vaccination.

* Get Applied Vaccinations per Day
Endpoint: /vaccinations/day
Method: GET
Produces: application/json
Description: Retrieves a list of applied vaccinations for the specified date.
Parameters: date - Date for which applied vaccinations are requested (YYYY-MM-DD)
Response: Returns a JSON array of VaccinationResponse objects containing information about each applied vaccination.

* Get Confirmed Vaccinations within Date Range
Endpoint: /vaccinations
Method: GET
Produces: application/json
Description: Retrieves a list of confirmed vaccinations within the specified date range.
Parameters:
startDate - Start date of the date range(YYYY-MM-DDT00:00:00)
endDate - End date of the date range(YYYY-MM-DDT00:00:00)
Response: Returns a JSON array of VaccinationResponse objects containing information about each confirmed vaccination within the date range.

* Usage
Clone the repository.
Build and run the application.
Access the API endpoints using a REST client such as Postman.
