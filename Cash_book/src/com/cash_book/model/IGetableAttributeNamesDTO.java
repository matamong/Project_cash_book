package com.cash_book.model;

import java.util.List;

public interface IGetableAttributeNamesDTO {
	abstract public List<String> getNames(IGetableAttributeNamesDTO target);
}
