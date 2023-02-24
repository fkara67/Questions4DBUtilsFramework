@db
  Feature: Homework DB verification

    # List all the movies with the most copies in store 1 in ordered by film id.
  Scenario Outline: Verify the homework forth question's answer with DB
    Given the title "<title>" and count 4 should match the DB record
    Examples:
      | title            |
      | Academy Dinosaur |
      | Affair Prejudice |
      | Aladdin Calendar |
      | Alamo Videotape  |
      | Amadeus Holy     |