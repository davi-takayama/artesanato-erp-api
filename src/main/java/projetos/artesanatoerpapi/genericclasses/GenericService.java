package projetos.artesanatoerpapi.genericclasses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Slf4j
public abstract class GenericService<Orm extends BaseOrm, Dto extends BaseDto, ListedItem extends ListedItemDto> {

    protected ConverterInterface<Orm, Dto, ListedItem> converter;
    protected JpaRepository<Orm, UUID> repository;
    protected Class<Orm> entityClass;

    protected ApiResponseDto<Dto> create(
            Dto dto, Function<Orm, Void> beforePersistOperation, Function<Orm, Void> afterPersistOperations) {
        Orm orm = this.converter.dtoToOrm(dto);
        if (beforePersistOperation != null) {
            beforePersistOperation.apply(orm);
            log.info("{} before-create operation applied", this.entityClass.getSimpleName());
        }
        this.repository.save(orm);
        log.info("{} created successfully: id - {}", this.entityClass.getSimpleName(), orm.getId());
        if (afterPersistOperations != null) {
            afterPersistOperations.apply(orm);
            log.info("{} after-create operation applied", this.entityClass.getSimpleName());
        }
        return new ApiResponseDto<>(this.converter.ormToDto(orm));
    }

    protected ApiResponseDto<List<ListedItem>> retrieveAll() {
        List<Orm> ormList = this.repository.findAll();
        List<ListedItem> dtoList = this.converter.ormListToListedItemm(ormList);
        log.info("{} list retrieved successfully: size - {}", this.entityClass.getSimpleName(), dtoList.size());
        return new ApiResponseDto<>(dtoList);
    }

    protected ApiResponseDto<Dto> retrieveById(UUID id, Function<Dto, Dto> afterRetrieveOperation) {
        Orm orm = this.repository.findById(id).orElseThrow(() -> new RuntimeException(this.entityClass.getSimpleName() + " not found: id - " + id));
        Dto dto = this.converter.ormToDto(orm);
        log.info("{} found: id - {}", this.entityClass.getSimpleName(), orm.getId());
        if (afterRetrieveOperation != null) {
            dto = afterRetrieveOperation.apply(dto);
            log.info("{} after-find operation applied", this.entityClass.getSimpleName());
        }
        return new ApiResponseDto<>(dto);
    }

    public Orm findOrmById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException(this.entityClass.getSimpleName() + " not found: id - " + id));
    }

    protected ApiResponseDto<Dto> update(
            Dto dto, Function<Orm, Void> beforePersistOperation, Function<Orm, Void> afterPersistOperations) {
        Orm orm = this.repository.findById(UUID.fromString(dto.getId())).orElseThrow(() -> new RuntimeException(this.entityClass.getSimpleName() + " not found: id - " + dto.getId()));

        orm = this.converter.dtoToOrm(dto, orm);
        if (beforePersistOperation != null) {
            beforePersistOperation.apply(orm);
            log.info("{} before-update operation applied: id - {}", this.entityClass.getSimpleName(), orm.getId());
        }
        orm.setUpdatedAt(new Date());
        this.repository.save(orm);
        log.info("{} updated successfully: id - {}", this.entityClass.getSimpleName(), orm.getId());
        if (afterPersistOperations != null) {
            afterPersistOperations.apply(orm);
            log.info("{} after-update operation applied: id - {}", this.entityClass.getSimpleName(), orm.getId());
        }
        return new ApiResponseDto<>(this.converter.ormToDto(orm));
    }

    protected ApiResponseDto<String> delete(UUID id, Function<Orm, Boolean> beforeDeleteOperation) {
        Orm orm = this.repository.findById(id).orElseThrow(() -> new RuntimeException(this.entityClass.getSimpleName() + " not found: id - " + id));

        if (beforeDeleteOperation != null) {
            if (!beforeDeleteOperation.apply(orm)) {
                log.info(
                        "{} delete-operation aborted by before delete operation: id - {}",
                        this.entityClass.getSimpleName(),
                        orm.getId());
                throw new RuntimeException(this.entityClass.getSimpleName() + " delete-operation aborted by before delete operation: id - " + orm.getId());
            }
            log.info("{} before-delete operation applied: id - {}", this.entityClass.getSimpleName(), orm.getId());
        }
        this.repository.delete(orm);
        log.info("{} deleted successfully: id - {}", this.entityClass.getSimpleName(), orm.getId());
        return new ApiResponseDto<>(this.entityClass.getSimpleName() + " deleted successfully");
    }

    @SuppressWarnings("unused")
    public Orm dtoToOrm(Dto dto, Orm orm) {
        return this.converter.dtoToOrm(dto, orm);
    }

    @SuppressWarnings("unused")

    public Dto ormToDto(Orm orm) {
        return this.converter.ormToDto(orm);
    }

    @SuppressWarnings("unused")

    public List<Dto> ormListToDtoList(List<Orm> ormList) {
        return this.converter.ormListToDtoList(ormList);
    }

    @SuppressWarnings("unused")

    public List<Orm> dtoListToOrmList(List<Dto> dtoList) {
        return this.converter.dtoListToOrmList(dtoList);
    }
}
