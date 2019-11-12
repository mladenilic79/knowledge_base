# controller methods do anything included comunication with the model
# & db querying & than passing data to the view

# params - The params live in the url or in the post body of a form (for one request only)
# params - all parameters that corresponding page has access to (for that one request)
# session - Session persists between multiple requests (the info are often stored in cookies)
# session - info to be persisted (cart, user..), available in controller & in a view

class BlogsController < ApplicationController

  # here before_action calls set_blog method before specified methods
  # (see end of page, returns record specified by id for return one record)
  before_action :set_blog, only: [:show, :edit, :update, :destroy]

  # GET /blogs
  # GET /blogs.json
  # index returns all records
  def index
    # calling model and putting in instance variable
    # (making data available to the matching view page)
    @blogs = Blog.all

    # doing manual debugging
    puts '*' * 500
    puts @blogs.inspect
    # or
    puts caller
    puts '*' * 500

    # byebug debugging (creates breakpoint)
    byebug
    # call variables at breakpoint, for example:
    # (byebug) @blogs
    # (byebug) session
    # (byebug) params
    # for next step without function call
    # (byebug) next
    # for next step with stepping into function
    # (byebug) next
    # continue returns to code execution
    # (byebug) continue

    # pry debugging (creates breakpoint)
    binding.pry
    # pry()> @blogs
    # pry()> session
    # pry()> params
    # for next step without function call
    # (pry()>) next
    # for next step with stepping into function
    # (pry()>) next
    # continue returns to code execution
    # pry()> continue

    # alternatively in non exists returns nil instead of error
    @blogs2 = Blog.all&

    # alternatively pass parameter directly
    @blogs3 = Blog.where(blog_name: 'random name')

    # added for showcasing views/blog/index
    @blog = Blog.last
  end

  # GET /blogs/1
  # GET /blogs/1.json
  # show returns one record
  def show
    # here empty is default

    # overriding value from application controller/concern
    @page_title = "overriding default name"
    @seo_keywords = Blog.last.blog_name
  end

  # GET /blogs/new
  # just creates/renders blank form than calls create
  def new
    @blog = Blog.new
  end

  # GET /blogs/1/edit
  # just creates/renders blank form than calls update
  def edit
  end

  # POST /blogs
  # POST /blogs.json
  def create
    # parameter is return from method blog_params see below
    @blog = Blog.new(blog_params)

    # respond_to method are referencing response that will be sent to the view
    respond_to do |format|
      # if it was valid & saved than:
      if @blog.save
        # redirect redirecting to another route
        format.html { redirect_to @blog, notice: 'Blog was successfully created.' }
        # same as
        format.html { redirect_to blog_path(@blog), notice: 'Blog was successfully created.' }
        # alternatively without parameter if parameter not required
        format.html { redirect_to blog_path, notice: 'Your blog item is now live.' }
        format.json { render :show, status: :created, location: @blog }
      else
        # render creating
        format.html { render :new }
        format.json { render json: @blog.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /blogs/1
  # PATCH/PUT /blogs/1.json
  def update
    respond_to do |format|
      if @blog.update(blog_params)
        format.html { redirect_to @blog, notice: 'Blog was successfully updated.' }
        format.json { render :show, status: :ok, location: @blog }
      else
        format.html { render :edit }
        format.json { render json: @blog.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /blogs/1
  # DELETE /blogs/1.json
  def destroy
    @blog.destroy
    respond_to do |format|
      format.html { redirect_to blogs_url, notice: 'Blog was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  def missing
  end

  # showcase static method & scopes instead of parameter in controller
  # (routes, models/blogs, controller/blogs_controller, views/custom_methods_from_model)
  def custom_methods_from_model
    @classic_method = Blog.static_method_from_model
    @scope = Blog.scope_blogs_by_name
    @scopeid = Blog.scope_blogs_by_parent_id(Parent.last.id)
  end

  private

  # Use callbacks to share common setup or constraints between actions
  # this method returns specific record for use in other methods
  def set_blog
    @blog = Blog.find(params[:id])
  end

  # Never trust parameters from the scary internet, only allow the white list through
  # permit only specified parameters
  def blog_params
    # default without any associations
    # params.require(:blog).permit(:blog_name, :blog_number)

    # showcasing association with parent class
    # (controllers/blogs_controller, views/show, views/index, views/_form)
    params.require(:blog).permit(:blog_name, :blog_number, :parent_id)
  end

=begin
  add :toggle_status into before action methods

  # method for including specific app/view/layout
  # if not specified it will be default (views/layouts/application.html.erb)
  layout("blog")

  # added method for status field enum in model (see model & migration & view & routes also)
  def toggle_status
    if @blog.draft?
      @blog.published!
    elsif @blog.published?
      @blog.draft!
    end
    redirect_to blogs_url, notice: 'post status has been updated'
  end

  def set_blog
    # insert friendly method to be used with permalinks (see instructions for friendly_id gem)
    @blog = Blog.friendly.find(params[:id])
  end
=end

end
