class ThemesController < ApplicationController

  before_action :set_theme, only: [:show, :edit, :update, :destroy]

  def index
    @themes = Theme.all
  end

  def show
  end

  def new
    @theme = Theme.new
  end

  def edit
  end

  def create
    @theme = Theme.new(theme_params)
    respond_to do |format|
      if @theme.save
        format.html { redirect_to theme_path(@theme), notice: 'theme was successfully created.' }
      else
        format.html { render :new }
      end
    end
  end

  def update
    respond_to do |format|
      if @theme.update(theme_params)
        format.html { redirect_to @theme, notice: 'theme was successfully updated.' }
      else
        format.html { render :edit }
      end
    end
  end

  def destroy
    @theme.destroy
    respond_to do |format|
      format.html { redirect_to themes_url, notice: 'theme was successfully destroyed.' }
    end
  end

  private

  def set_theme
    @theme = Theme.find(params[:id])
  end

  def theme_params
    params.require(:theme).permit(:theme_name, :theme_number)
  end

end
