<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <title>UMS | Student Bills</title>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">UMS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h2 class="text-center mb-5">All Student Bills</h2>
        <table class="table table-bordered">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Fullname</th>
              <th scope="col">Program</th>
              <th scope="col">Years</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
              <%
              try {
                  String url = "jdbc:mysql://localhost:3306/studentadmission";
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection(url, "root", "");
                  Statement stmt = con.createStatement();
                  ResultSet rs = stmt.executeQuery("select * from students");
              %>
              <%
              int count = 1;
              while (rs.next()) {
              %>
            <tr>
              <th scope="row"><%= count++ %></th>
              <td><%= rs.getString(3) %></td>
              <td><%= rs.getString(4) %></td>
              <td><%= rs.getString(5) %></td>
              <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal<%= rs.getString(1) %>">
                add payment
                </button>
              </td>
            </tr>
            <!-- Modal -->
<div class="modal fade" id="exampleModal<%= rs.getString(1) %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Payment</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="addpayment" method="post">
          <input type="hidden" name="id" value="<%= rs.getString(1) %>">
          <input type="hidden" name="studentname" value="<%= rs.getString(3) %>">
          <div class="row">
            <div class="col-sm-10 m-2"> 
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">Tsh</span>
                <span class="input-group-text">000</span>
              </div>
              <input type="text" name="amount" class="form-control">
            </div>
            </div>
            
          </div>
          <div class="row">
            <div class="col-sm-10">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Submit</button>
            </div>
          </div>
      </div>
    </form>
    </div>
  </div>
</div>
            <% } %>
          </tbody>
        </table>

        <%
  } catch (Exception ex) {
  System.out.println("Exception Occurred:: " + ex.getMessage());
  }
  %>
      </div>
    </div>
  </div> 

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</body>

</html>