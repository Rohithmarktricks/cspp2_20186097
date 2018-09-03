/**
 * Class StudentsDetails.
 */

class StudentDetails {

    /**
     * Constructs the object.
     *
     * @param      name        The name
     * @param      rollNumber  The roll number
     * @param      marks1      The marks 1
     * @param      marks2      The marks 2
     * @param      marks3      The marks 3
     */
    protected StudentDetails(final String name,
                             final String rollNumber, final double marks1,
                             final double marks2, final double marks3) {
        //System.out.format("%.1f\n", averageMarks(marks1, marks2, marks3));
        System.out.println(Math.floor(averageMarks(marks1,
                                      marks2, marks3) * 10) / 10.0);
    }
    /**
     * THREE = 3.
     */
    private static int tHREE = 3;
    /**
     * average marks.
     *
     * @param      marks1  The marks 1
     * @param      marks2  The marks 2
     * @param      marks3  The marks 3
     *
     * @return     average marks.
     */
    static final double averageMarks(final double marks1,
                                     final double marks2, final double marks3) {
        double sum = marks1 + marks2 + marks3;
        return  sum / tHREE;
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        StudentDetails studentdetails1 = new StudentDetails("Sangay",
                "IT201985001", 7.5, 7.0, 8.0);
        StudentDetails studentdetails2 = new StudentDetails("Bidhya",
                "IT201985003", 8.5, 6.0, 7.5);
        StudentDetails studentdetails3 = new StudentDetails("Kelzang",
                "IT201985065", 7.5, 8.0, 9.0);
    }
}
