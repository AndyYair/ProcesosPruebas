package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(ReglaController)
@Mock(Regla)
class ReglaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/regla/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reglaInstanceList.size() == 0
        assert model.reglaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.reglaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reglaInstance != null
        assert view == '/regla/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/regla/show/1'
        assert controller.flash.message != null
        assert Regla.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/regla/list'

        populateValidParams(params)
        def regla = new Regla(params)

        assert regla.save() != null

        params.id = regla.id

        def model = controller.show()

        assert model.reglaInstance == regla
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/regla/list'

        populateValidParams(params)
        def regla = new Regla(params)

        assert regla.save() != null

        params.id = regla.id

        def model = controller.edit()

        assert model.reglaInstance == regla
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/regla/list'

        response.reset()

        populateValidParams(params)
        def regla = new Regla(params)

        assert regla.save() != null

        // test invalid parameters in update
        params.id = regla.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/regla/edit"
        assert model.reglaInstance != null

        regla.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/regla/show/$regla.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        regla.clearErrors()

        populateValidParams(params)
        params.id = regla.id
        params.version = -1
        controller.update()

        assert view == "/regla/edit"
        assert model.reglaInstance != null
        assert model.reglaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/regla/list'

        response.reset()

        populateValidParams(params)
        def regla = new Regla(params)

        assert regla.save() != null
        assert Regla.count() == 1

        params.id = regla.id

        controller.delete()

        assert Regla.count() == 0
        assert Regla.get(regla.id) == null
        assert response.redirectedUrl == '/regla/list'
    }
}
