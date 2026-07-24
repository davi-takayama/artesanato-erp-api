package projetos.artesanatoerpapi.genericclasses;

import java.util.List;

public interface ConverterInterface<Orm extends BaseOrm, Dto extends BaseDto, ListedItem extends ListedItemDto> {
    Orm dtoToOrm(Dto dto, Orm orm);

    Orm dtoToOrm(Dto dto);

    Dto ormToDto(Orm orm, Dto dto);

    Dto ormToDto(Orm orm);

    ListedItem ormToListedItem(Orm orm);

    List<Orm> dtoListToOrmList(final List<Dto> dtoList);

    List<Dto> ormListToDtoList(final List<Orm> ormList);

    List<ListedItem> ormListToListedItemm(final List<Orm> ormList);
}
