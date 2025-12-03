package ultity;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static ultity.Helper.ERROR_DATE;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
    //    public static void validateEmployeeCode(String code) throws UserException {
//        if (!Pattern.matches("NV-\\d{4}", code)) {
//            throw new UserException("Mã nhân viên không hợp lệ. Định dạng NV-YYYY.");
//        }
//    }
//
//    public static void validateName(String name) throws UserException {
//        if (!Pattern.matches("([A-Z][a-z]+\\s?)+", name)) {
//            throw new UserException("Tên nhân viên không hợp lệ. Viết hoa chữ cái đầu mỗi từ.");
//        }
//    }
//
    public static void validateBirthDate(String birthDateStr) throws UserException {
        try {
            String[] parts = birthDateStr.split("/");
            if (parts.length != 3) {
                throw new UserException(ERROR_DATE);
            }

            int year = Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);

            LocalDate.of(year, month, day);

            int age = LocalDate.now().getYear() - year;
            if (age <= 0) {
                throw new UserException("Ngày không hợp lệ ");
            }

        } catch (Exception e) {
            throw new UserException("Ngày sinh không hợp lệ. Định dạng dd/MM/yyyy.");
        }
    }
    //
//    public static void validateIdPerson(String cmnd) throws UserException {
//        if (!Pattern.matches("\\d{9}|\\d{12}", cmnd)) {
//            throw new UserException("CMND phải đủ 9 hoặc 12 số.");
//        }
//    }
//
    public static void validatePhone(String phone) throws UserException {
        if (!Pattern.matches("0\\d{9}", phone)) {
            throw new UserException("Số điện thoại phải bắt đầu từ 0 và đủ 10 số.");
        }
    }
    //
//    public static void validateSalary(double salary) throws UserException {
//        if (salary <= 0) {
//            throw new UserException("Lương phải lớn hơn 0.");
//        }
//    }
//
//    public static void validateEmail(String email) throws UserException {
//        if (!Pattern.matches("\\w+@\\w+(\\.\\w+)+", email)) {
//            throw new UserException("Email không hợp lệ. Ví dụ: example@gmail.com");
//        }
//    }
//
    public static void validateEmail(String email) throws UserException {
        if (!email.matches(".+@gmail\\.com")) {
            throw new UserException("Email không hợp lệ. Phải có dạng @gmail.com");
        }
    }
//
//    public static void validateCustomerCode(String code) throws UserException {
//        if (!Pattern.matches("KH-\\d{4}", code)) {
//            throw new UserException("Mã nhân viên không hợp lệ. Định dạng KH-YYYY.");
//        }
//    }
//
//    public static void validateDate(String birthDateStr, int minAge, int maxAge) throws UserException {
//        try {
//            String[] parts = birthDateStr.split("/");
//            if (parts.length != 3) {
//                throw new UserException("Ngày sinh không hợp lệ. Định dạng dd/MM/yyyy.");
//            }
//
//            int year = Integer.parseInt(parts[2]);
//            int month = Integer.parseInt(parts[1]);
//            int day = Integer.parseInt(parts[0]);
//
//            LocalDate temp = LocalDate.of(year, month, day);
//
//            int age = LocalDate.now().getYear() - year;
//
//            if (age < minAge || age > maxAge) {
//                throw new UserException("Tuổi phải nằm trong khoảng " + minAge + " đến " + maxAge + " tuổi.");
//            }
//
//        } catch (Exception e) {
//            throw new UserException("Ngày sinh không hợp lệ. Định dạng dd/MM/yyyy.");
//        }
//    }
//
//    public static void validateFacilityCode(String code, String prefix) throws UserException {
//        String regex = "^"+prefix+"-\\d{4}$";
//        if (!Pattern.matches(regex,code) ){
//            throw new UserException("Mã không hợp lệ, phải có dạng " + prefix + "-YYYY");
//        }
//    }
}


