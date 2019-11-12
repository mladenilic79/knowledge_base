# concern are used for some extra data functionality

# in rails module name & file name must match
module SetSource
  # default extend for concern
  extend ActiveSupport::Concern

  included do
    # this run before any other controller (same as before_filter)
    before_action :set_source
  end

  def set_source
    # set only if exists
    # set varibale source (created on spot in session) equal to variable q (also created on spot in params)
    # and pass value from params to session so that we could access on multiple pages
    session[:source] = params[:q] if params[:q]
  end
end
