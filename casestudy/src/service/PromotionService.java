package service;

import repository.IPromotionRepository;
import repository.PromotionRepository;

import static controller.FuramaController.sc;

public class PromotionService implements IPromotionService {
    IPromotionRepository promotionRepository = new PromotionRepository();

    @Override
    public void displayUseService(int year) {
        promotionRepository.displayUseService(year);
    }

    @Override
    public void displayGetVoucher() {
        System.out.println("Nhập 10%");
        int temp1=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập 20%");
        int temp2=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập 50%");
        int temp3=Integer.parseInt(sc.nextLine());
        promotionRepository.displayGetVoucher(temp1,temp2,temp3);
    }
}
