package utils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

import static view.RunApp.ERROR_DATE;
import static view.RunApp.ERROR_INPUT;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }

    //    public static void validateID(String code) throws UserException {
//        if (!Pattern.matches("STK\\d{4}", code)) {
//            throw new UserException("Mã nhân viên không hợp lệ. Định dạng STKYYYY.");
//        }
//    }
//
    public static void validateName(String name) throws UserException {
        if (!Pattern.matches("([A-Z][a-z]+\\s?)+", name)) {
            throw new UserException("Tên không hợp lệ. Viết hoa chữ cái đầu mỗi từ.");
        }
    }
//
//    public static void validateBirthDate(String birthDateStr) throws UserException {
//        try {
//            String[] parts = birthDateStr.split("/");
//            if (parts.length != 3) {
//                throw new UserException(ERROR_DATE);
//            }
//
//            int year = Integer.parseInt(parts[2]);
//            int month = Integer.parseInt(parts[1]);
//            int day = Integer.parseInt(parts[0]);
//
//            LocalDate.of(year, month, day);
//
//            int age = LocalDate.now().getYear() - year;
//            if (age <= 0) {
//                throw new UserException("Ngày không hợp lệ ");
//            }
//
//        } catch (Exception e) {
//            throw new UserException("Ngày sinh không hợp lệ. Định dạng dd/MM/yyyy.");
//        }
//    }
//
    public static void validateIdPerson(String cmnd) throws UserException {
        if (!Pattern.matches("\\d{9}|\\d{12}", cmnd)) {
            throw new UserException("CMND phải đủ 9 hoặc 12 số.");
        }
    }
//
    public static void validatePhone(String phone) throws UserException {
        if (!Pattern.matches("0\\d{9}", phone)) {
            throw new UserException("Số điện thoại phải bắt đầu từ 0 và đủ 10 số.");
        }
    }
//
    public static void validateSalary(double salary) throws UserException {
        if (salary <= 0) {
            throw new UserException("Lương phải lớn hơn 0.");
        }
    }
//
//    public static void validateEmail(String email) throws UserException {
//        if (!Pattern.matches("\\w+@\\w+(\\.\\w+)+", email)) {
//            throw new UserException("Email không hợp lệ. Ví dụ: example@gmail.com");
//        }
//    }
//
//    public static void validateEmail(String email) throws UserException {
//        if (!email.matches(".+@gmail\\.com")) {
//            throw new UserException("Email không hợp lệ. Phải có dạng @gmail.com");
//        }
//    }
//
    public static void validateCustomerCode(String code) throws UserException {
        if (!Pattern.matches("KH-\\d{4}", code)) {
            throw new UserException("Mã khách hàng không hợp lệ. Định dạng KH-YYYY.");
        }
    }
//
    public static void validateDate(String birthDateStr, int minAge, int maxAge) throws UserException {
        try {
            String[] parts = birthDateStr.split("/");
            if (parts.length != 3) {
                throw new UserException(ERROR_DATE);
            }

            int year = Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);

            LocalDate temp = LocalDate.of(year, month, day);

            int age = LocalDate.now().getYear() - year;

            if (age < minAge || age > maxAge) {
                throw new UserException("Tuổi phải nằm trong khoảng " + minAge + " đến " + maxAge + " tuổi.");
            }

        } catch (UserException e) {
            throw e;
        } catch (Exception e) {
            throw new UserException(ERROR_DATE);
        }
    }

    public static void validateFutureDate(String dateStr) throws UserException {
        try {
            String[] parts = dateStr.split("/");
            if (parts.length != 3) {
                throw new UserException(ERROR_DATE);
            }

            int year = Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);

            LocalDate date = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();

            if (!date.isAfter(today)) {
                throw new UserException(ERROR_INPUT);
            }

        } catch (UserException e) {
            throw e;
        } catch (Exception e) {
            throw new UserException(ERROR_DATE);
        }
    }

//
//    public static void validateFacilityCode(String code, String prefix) throws UserException {
//        String regex = "^"+prefix+"-\\d{4}$";
//        if (!Pattern.matches(regex,code) ){
//            throw new UserException("Mã không hợp lệ, phải có dạng " + prefix + "-YYYY");
//        }
//    }

    public static void validateInput(int input) throws UserException {
        if (input < 1) {
            throw new UserException(ERROR_INPUT);
        }
    }

    public static void validateEmployeeCode(String temp) {
        if (!Pattern.matches("NV-\\d{4}", temp)) {
            throw new UserException("Mã nhân viên không hợp lệ. Định dạng NV-YYYY.");
        }
    }

    public static void validateHouse(String temp) {
        if (!Pattern.matches("SVHO-\\d{4}", temp)) {
            throw new UserException("Mã không hợp lệ. Định dạng SVHO-YYYY.");
        }
    }

    public static void validateVilla(String temp) {
        if (!Pattern.matches("SVVL-\\d{4}", temp)) {
            throw new UserException("Mã không hợp lệ. Định dạng SVVL-YYYY.");
        }
    }

    public static void validateRoom(String temp) {
        if (!Pattern.matches("SVRO-\\d{4}", temp)) {
            throw new UserException("Mã không hợp lệ. Định dạng SVRO-YYYY.");
        }
    }

    public static void validateNameService(String temp){
        if (!Pattern.matches("^[A-Z][a-z]+$", temp)) {
            throw new UserException("Tên không hợp lệ. Viết hoa kí tự đầu.");
        }
    }

    public static void validateNumberPeople(int input) throws UserException {
        if (input < 1 || input>20) {
            throw new UserException(ERROR_INPUT);
        }
    }

    public static void validateDrone(String temp) {
        if (!Pattern.matches("DRN-\\S{3}", temp)) {
            throw new UserException("Mã không hợp lệ. Định dạng DRN-YYY.");
        }
    }

    public static void validateCar(String temp) {
        if (!Pattern.matches("XTT-\\S{3}", temp)) {
            throw new UserException("Mã không hợp lệ. Định dạng XTT-YYY.");
        }
    }

    public static void validateYear(String temp){
        LocalDate now=LocalDate.now();
        if(Integer.parseInt(temp)>now.getYear()){
            throw new UserException("Năm sản xuất không hợp lệ");
        }
    }


}
