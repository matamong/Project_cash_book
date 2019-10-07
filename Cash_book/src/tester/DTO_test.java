package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cash_book.model.CashBookDAO;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.dbConnection.DBConnection;
import com.cash_book.model.member.MemberDTO;

public class DTO_test {
	public static void main(String[] args) {
		CashBookDAO dao = new CashBookDAO(DBConnection.getConnection());

		GetableAttributeNamesDTO memberDTO = new MemberDTO("01095513439", "chocobe", "tiger");
		List<GetableAttributeNamesDTO> resultSelect = dao.select(memberDTO);
		List<List<String>> resultList = new ArrayList<List<String>>();
		
		
		for(GetableAttributeNamesDTO dto : resultSelect) {
			Map<String, String> values = dto.getAttributeValues();
			String name = values.get(MemberDTO.NAME_NAME);
			String phone = values.get(MemberDTO.PHONE_NAME);
			String pw = values.get(MemberDTO.PW_NAME);
			
			List<String> currentResultList = new ArrayList<String>();
			currentResultList.add(name);
			currentResultList.add(phone);
			currentResultList.add(pw);
			
			resultList.add(currentResultList);
		}
	}
}
