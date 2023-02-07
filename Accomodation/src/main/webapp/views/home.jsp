<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <title>University System | Accomodation</title>
  </head>
  <body>
    

    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <h2 class="text-center mb-5">Add Accommodation</h2>
          <form>
            <div class="form-group">
              <label for="hostel">Hostel</label>
              <select class="form-control" id="">
                <option selected disabled>Select Hostel</option>
                <option value="Mkwawa">Mkwawa</option>
                <option value="Mirambo">Mirambo</option>
              </select>
            </div>
            <div class="form-group">
              <label for="roomType">Room Type</label>
              <select class="form-control" id="roomType">
                <option selected disabled>Select Room Type</option>
                <option value="single">Single</option>
                <option value="double">Double</option>
              </select>
            </div>
            <div class="form-group">
              <label for="roomNumber">Room Number</label>
              <input type="text" class="form-control" id="roomNumber" placeholder="Enter room number">
            </div>
            <div class="form-group">
              <label for="checkInDate">Check-in Date</label>
              <input type="date" class="form-control" id="checkInDate">
            </div>
            <div class="form-group">
              <label for="checkOutDate">Check-out Date</label>
              <input type="date" class="form-control" id="checkOutDate">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/allhostels" class="btn btn-success">All Hostels</a>
          </form>
        </div>
      </div>
    </div>
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
  </body>
</html>
