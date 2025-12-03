package service;

import repository.IPromotionRepository;
import repository.PromotionRepository;

public class PromotionService implements IPromotionService {
    IPromotionRepository promotionRepository = new PromotionRepository();

    @Override
    public void displayUseService() {
        promotionRepository.displayUseService();
    }

    @Override
    public void displayGetVoucher() {
        promotionRepository.displayGetVoucher();
    }
}
