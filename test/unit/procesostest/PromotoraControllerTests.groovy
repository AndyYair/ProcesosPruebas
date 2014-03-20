package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(PromotoraController)
@Mock(Promotora)
class PromotoraControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/promotora/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.promotoraInstanceList.size() == 0
        assert model.promotoraInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.promotoraInstance != null
    }

    void testSave() {
        controller.save()

        assert model.promotoraInstance != null
        assert view == '/promotora/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/promotora/show/1'
        assert controller.flash.message != null
        assert Promotora.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/promotora/list'

        populateValidParams(params)
        def promotora = new Promotora(params)

        assert promotora.save() != null

        params.id = promotora.id

        def model = controller.show()

        assert model.promotoraInstance == promotora
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/promotora/list'

        populateValidParams(params)
        def promotora = new Promotora(params)

        assert promotora.save() != null

        params.id = promotora.id

        def model = controller.edit()

        assert model.promotoraInstance == promotora
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/promotora/list'

        response.reset()

        populateValidParams(params)
        def promotora = new Promotora(params)

        assert promotora.save() != null

        // test invalid parameters in update
        params.id = promotora.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/promotora/edit"
        assert model.promotoraInstance != null

        promotora.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/promotora/show/$promotora.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        promotora.clearErrors()

        populateValidParams(params)
        params.id = promotora.id
        params.version = -1
        controller.update()

        assert view == "/promotora/edit"
        assert model.promotoraInstance != null
        assert model.promotoraInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/promotora/list'

        response.reset()

        populateValidParams(params)
        def promotora = new Promotora(params)

        assert promotora.save() != null
        assert Promotora.count() == 1

        params.id = promotora.id

        controller.delete()

        assert Promotora.count() == 0
        assert Promotora.get(promotora.id) == null
        assert response.redirectedUrl == '/promotora/list'
    }
}
