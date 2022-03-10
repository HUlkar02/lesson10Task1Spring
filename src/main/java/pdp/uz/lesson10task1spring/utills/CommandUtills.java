package pdp.uz.lesson10task1spring.utills;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pdp.uz.lesson10task1spring.exceptions.PageSizeException;


public class CommandUtills {
    public static boolean validatePageAndSize(int page,int size) throws PageSizeException {
        if (page<0){
            throw new PageSizeException("Invalid Page number. Page number must not be less than zero!");
        }else if (size<0){
            throw new PageSizeException("Invalid Page size. Page size must not be less than zero!");
        }
        else if (size>AppConstants.MAX_PAGE_SIZE){
            throw new PageSizeException("Invalid Page size. Page size must not be greater than "+AppConstants.MAX_PAGE_SIZE+"!");
        }
        return true;
    }

    public static Pageable simplePageable(int page,int size) throws PageSizeException {
        validatePageAndSize(page, size);
        return PageRequest.of(page,size);
    }

}
